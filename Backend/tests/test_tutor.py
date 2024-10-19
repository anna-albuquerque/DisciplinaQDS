import re

class Tutor:
    def __init__(self, nome, sobrenome, data_nascimento, cpf, email, senha, telefone, foto_perfil):
        self.nome = nome
        self.sobrenome = sobrenome
        self.data_nascimento = data_nascimento
        self.cpf = cpf
        self.email = email
        self.senha = senha
        self.telefone = telefone
        self.foto_perfil = foto_perfil

    def validar_email(self):
        # Expressão regular para validar e-mail
        padrao_email = r'^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$'
        return re.match(padrao_email, self.email) is not None

    def validar_cpf(self):
        cpf_numeros = re.sub(r'\D', '', self.cpf)
        if len(cpf_numeros) != 11 or cpf_numeros == cpf_numeros[0] * 11:
            return False

        soma = sum(int(cpf_numeros[i]) * (10 - i) for i in range(9))
        digito1 = 11 - (soma % 11)
        digito1 = 0 if digito1 >= 10 else digito1

        soma = sum(int(cpf_numeros[i]) * (11 - i) for i in range(10))
        digito2 = 11 - (soma % 11)
        digito2 = 0 if digito2 >= 10 else digito2

        return cpf_numeros[-2:] == f"{digito1}{digito2}"

def test_tutor():
    tutor = Tutor(
        "João",
        "Silva",
        "13/05/1991",
        "123.456.789-09",  
        "joao.silva@example.com",
        "SenhaSegura123",
        "123456789",
        True
    )

    # Testes de atributos
    assert tutor.nome == "João"
    assert tutor.sobrenome == "Silva"
    assert tutor.data_nascimento == "13/05/1991"
    
    # Testes de validação
    assert tutor.validar_cpf() == True  # O CPF é válido
    assert tutor.validar_email() == True  # O e-mail é válido
    
    tutor_invalido = Tutor(
        "Maria",
        "Oliveira",
        "05/07/1990",
        "111.111.111-11",  
        "maria.silva@@exemplo..com",  
        "SenhaSegura123",
        "987654321",
        False
    )

    assert tutor_invalido.validar_cpf() == False  # CPF inválido
    assert tutor_invalido.validar_email() == False  # E-mail inválido

if __name__ == "__main__":
    test_tutor()