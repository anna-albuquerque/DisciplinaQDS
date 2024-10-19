
import { Caracteristicas } from "./Caracteristicas";


export interface Cuidador{
    id?: number;
    nome: string;
    sobrenome: string;
    cpf: string;
    email: string;
    data_nascimento: string;
    telefone: string;
    instagram: string;
    cep: string;
    localidade: string;
    uf: string;
    numero: number;
    logradouro: string;
    caracteristicas: Caracteristicas[]
    senha?: string;
}