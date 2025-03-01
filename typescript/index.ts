// Declarando tipos básicos
let nome: string = 'John';
let idade:number = 30;
let ativo: boolean = true;
let lista: number[] = [1,2,3];
let tupla: [string, number] = ['John', 30];

// Exemplo de função
function somar(a: number, b: number): number {
    return a + b;
}

console.log(somar(5,3));

// somar('5', '3') // Erro: Argumento do tipo 'string' não é atribuível ao tipo 'number'

// Any e Void
// Any: Desativa a checagem de tipo (use com cuidado).
// void: Indica que uma função não retorna nada.

let variavel: any = 5;
variavel = 'texto';

function logMensagem(mensagem: string): void {
    console.log(mensagem);
}

logMensagem('Olá mundo!');

// Union Types
// Permite que uma variável aceite mais de um tipo.
let id: string | number;
id = "abc123"; // Ok
id = 123; // Ok
// id = true // Erro

// Interfaces
// Útil para definir a estrutura de objetos. Essencial para Angular e React.
interface Pessoa {
    nome: string;
    idade: number;
    ativo?: boolean;
}

const usuario: Pessoa = {
    nome: "Maria",
    idade: 25,
}

function saudar(pessoa: Pessoa): string {
    return `Olá, ${pessoa.nome}"`;
}

console.log(saudar(usuario));