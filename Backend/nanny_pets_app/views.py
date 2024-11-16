"""
Este módulo contém as views relacionadas ao gerenciamento de cuidadores, tutores e características.
"""

from django.shortcuts import get_object_or_404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status, generics
from rest_framework.authtoken.views import ObtainAuthToken
from rest_framework.authtoken.models import Token
from django_filters.rest_framework import DjangoFilterBackend
from django.contrib.auth.models import User  # Importando modelo User
from .serializers import (
    UserSerializer,
    TutorSerializer,
    CuidadorSerializer,
    CaracteristicasSerializer
)
from .models import Cuidador, Caracteristicas, Tutor

class CustomAuthToken(ObtainAuthToken):
    """View para autenticação personalizada de usuários utilizando tokens."""
    def post(self, request, *args, **kwargs):
        serializer = self.serializer_class(data=request.data, context={'request': request})
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        token, _ = Token.objects.get_or_create(user=user)
        return Response({
            'token': token.key,
            'user_id': user.pk,
            'email': user.email,
        })

class UserRegisterView(APIView):
    """View para registrar novos usuários."""
    def post(self, request):
        serializer = UserSerializer(data=request.data)
        if serializer.is_valid():
            if User.objects.filter(email=request.data.get('email')).exists():
                return Response({'detail': 'User with this email already exists.'},
                                status=status.HTTP_400_BAD_REQUEST)
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class CuidadorFiltradoView(generics.ListAPIView):
    """View para listar cuidadores com filtro por características."""
    serializer_class = CuidadorSerializer
    queryset = Cuidador.objects.all()
    filter_backends = [DjangoFilterBackend]
    filterset_fields = ['caracteristicas']

class CuidadorAPIView(APIView):
    """View para criar e listar cuidadores."""
    def post(self, request):
        serializer = CuidadorSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request):
        caracteristicas = request.query_params.getlist('caracteristicas')
        cuidadores = Cuidador.objects.all()
        if caracteristicas:
            cuidadores = cuidadores.filter(caracteristicas__id__in=caracteristicas).distinct()
        serializer = CuidadorSerializer(cuidadores, many=True)
        return Response(serializer.data)

class CaracteristicasAPIView(APIView):
    """View para listar todas as características."""
    def get(self, request):
        caracteristicas = Caracteristicas.objects.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)

class CaracteristicasDoCuidadorView(APIView):
    """View para listar as características de um cuidador específico."""
    def get(self, request, cuidador_id):
        cuidador = get_object_or_404(Cuidador, id=cuidador_id)
        caracteristicas = cuidador.caracteristicas.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)

class TutorAPIView(APIView):
    """View para criar e listar tutores."""
    def get(self, request):
        tutores = Tutor.objects.all()
        serializer = TutorSerializer(tutores, many=True)
        return Response(serializer.data)

    def post(self, request):
        serializer = TutorSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    