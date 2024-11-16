from django.shortcuts import render, get_object_or_404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status, generics, filters
from rest_framework.authtoken.views import ObtainAuthToken
from rest_framework.authtoken.models import Token
from .serializers import UserSerializer
from .models import Cuidador, Caracteristicas, Tutor
from .serializers import TutorSerializer, CuidadorSerializer, CaracteristicasSerializer
from django_filters.rest_framework import DjangoFilterBackend  # Importando filtro mais robusto

class CustomAuthToken(ObtainAuthToken):
    def post(self, request, *args, **kwargs):
        serializer = self.serializer_class(data=request.data, context={'request': request})
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        token, created = Token.objects.get_or_create(user=user)
        return Response({
            'token': token.key,
            'user_id': user.pk,
            'email': user.email
        })

class UserRegisterView(APIView):
    def post(self, request):
        serializer = UserSerializer(data=request.data)
        if serializer.is_valid():
            # Verificação se o usuário já existe
            if User.objects.filter(email=request.data.get('email')).exists():
                return Response({'detail': 'User with this email already exists.'}, 
                                tatus=status.HTTP_400_BAD_REQUEST)
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class CuidadorFiltradoView(generics.ListAPIView):
    serializer_class = CuidadorSerializer
    queryset = Cuidador.objects.all()
    filter_backends = [DjangoFilterBackend]  # Filtro mais robusto
    filterset_fields = ['caracteristicas']  # Filtro para o campo 'caracteristicas'

    def filter_queryset(self, queryset):
        caracteristicas = self.request.query_params.getlist('caracteristicas')
        if caracteristicas:
            queryset = queryset.filter(caracteristicas__id__in=caracteristicas).distinct()
        return queryset

class CuidadorAPIView(APIView):
    serializer_class = CuidadorSerializer

    def post(self, request):
        serializer = self.serializer_class(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request):
        caracteristicas = request.query_params.getlist('caracteristicas')
        # Filtro diretamente na consulta do banco de dados
        cuidadores = Cuidador.objects.all()
        if caracteristicas:
            cuidadores = cuidadores.filter(caracteristicas__id__in=caracteristicas).distinct()
        serializer = CuidadorSerializer(cuidadores, many=True)
        return Response(serializer.data)

class CaracteristicasAPIView(APIView):
    def get(self, request):
        caracteristicas = Caracteristicas.objects.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)

class CaracteristicasDoCuidadorView(APIView):
    def get(self, request, cuidador_id):
        cuidador = get_object_or_404(Cuidador, id=cuidador_id)
        caracteristicas = cuidador.caracteristicas.all()
        serializer = CaracteristicasSerializer(caracteristicas, many=True)
        return Response(serializer.data)

class TutorAPIView(APIView):
    serializer_class = TutorSerializer

    def get(self, request):
        tutores = Tutor.objects.all()
        serializer = TutorSerializer(tutores, many=True)
        return Response(serializer.data)

    def post(self, request):
        serializer = self.serializer_class(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
