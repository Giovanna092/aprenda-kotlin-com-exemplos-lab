enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val dataInscricao: String) {
    fun exibirInformacoes() {
        println("Nome: $nome")
        println("E-mail: $email")
        println("Data de Inscrição: $dataInscricao")
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //adicionando usuario à lista de inscritos
        inscritos.add(usuario)
    }
    
    fun exibir() {
        
        println("\nConteudos da formacao $nome: ")
        
        //listando os conteudos educacionais da formacao
		conteudos.forEach { conteudo ->
        	println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
    	}
        
        println("\nInscritos na formacao $nome: ")
        //listando os inscritos
        inscritos.forEach { inscrito -> 
        	inscrito.exibirInformacoes()
        }
    }
}

fun main() {
 
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
	val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 180)
	val conteudos = listOf(conteudo1, conteudo2)
    
    val usuario1 = Usuario("joao da Silva", "joaosilva@email.com.br", "22/08/2023")
    val usuario2 = Usuario("Ana Clara", "anaclara@email.com.br", "12/08/2023")
    val usuario3 = Usuario("Usuario 3", "user3@email.com.br", "15/08/2023")
    
    val fKotlin = Formacao("Formacao kotlin developer", conteudos)
    
    fKotlin.matricular(usuario1)
    fKotlin.matricular(usuario2)
    fKotlin.matricular(usuario3)
    
    fKotlin.exibir()
}
