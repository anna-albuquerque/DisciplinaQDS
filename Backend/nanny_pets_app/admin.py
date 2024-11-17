from django.contrib import admin

from .models import (AvaliacaoCuidador, AvaliacaoTutor, Caracteristicas,
                     Cuidador, ImagensAmbiente, Pessoa, Tutor)

# Register your models here.


admin.site.register(Cuidador)
admin.site.register(Tutor)
admin.site.register(AvaliacaoTutor)
admin.site.register(Caracteristicas)
admin.site.register(AvaliacaoCuidador)
admin.site.register(ImagensAmbiente)