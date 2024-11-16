"""
Este módulo contém as views relacionadas ao gerenciamento de cuidadores, tutores e características.
"""

from django.shortcuts import get_object_or_404
from rest_framework.authtoken.models import Token
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status, generics
from rest_framework.authtoken.views import ObtainAuthToken
from django_filters.rest_framework import DjangoFilterBackend
from django.contrib.auth.models import User  # pylint: disable=imported-auth-user
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
        """Cria ou recupera o token para um usuário autenticado."""
        serializer = self.serializer_class(data=request.data, context={'request': request})
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        token, _ = Token.objects.get_or_create(user=user)  # pylint: disable=no-member
        return Response({
            'token': token.key,
            'user_id': user.pk,
            'email': user.email,
        })


class UserRegisterView(APIView):
    """View para registrar novos usuários."""
    def post(self, request):
        """Registra um novo usuário."""
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
        """Cria um novo cuidador."""
        serializer = CuidadorSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request):
        """Lista cuidadores com filtro opcional por características."""
        caracteristicas = request.query_params.getlist('caracteristicas')
        cuidadores = Cuidador.objects.all()
        if caracteristicas:
            cuidadores = cuidadores.filter(caracteristicas__id__in=caracteristicas).distinct()
        serializer = CuidadorSerializer(cuidadores, many=True)
        return Response(serializer.data)


class CaracteristicasAPIView(APIView):
    """View para listar todas as características."""
    def get(self, request):
        """Lista todas as características cadastradas."""
        caracteristicas = Caracteristicas.objects.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)


class CaracteristicasDoCuidadorView(APIView):
    """View para listar as características de um cuidador específico."""
    def get(self, request, cuidador_id):
        """Lista as características de um cuidador."""
        cuidador = get_object_or_404(Cuidador, id=cuidador_id)
        caracteristicas = cuidador.caracteristicas.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)


class TutorAPIView(APIView):
    """View para criar e listar tutores."""
    def get(self, request):
        """Lista todos os tutores cadastrados."""
        tutores = Tutor.objects.all()
        serializer = TutorSerializer(tutores, many=True)
        return Response(serializer.data)

    def post(self, request):
        """Cria um novo tutor."""
        serializer = TutorSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
