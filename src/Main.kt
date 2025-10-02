// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val professor: String)

data class Professor(val nome: String)

data class Formacao(val nome: String, val nivel: Nivel,var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    val tempoCurso: Int
        get() = conteudos.sumOf { it.duracao }

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} foi adicionado ao curso ${nome}.\n")
    }

    fun detalhes() {
        println("Curso: $nome")
        println("Nível: $nivel")
        println("Conteúdos: ")
        println("Duração total do curso: $tempoCurso")
        conteudos.forEachIndexed { index, conteudo ->
            println(" ${index + 1}.${conteudo.nome}")
            println("    Duração: ${conteudo.duracao} min")
            println("    Professor: ${conteudo.professor}\n")
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usuario1 = Usuario("João Victor", "joao@email.com", 22)
    val usuario2 = Usuario("Layla", "layla@email.com", 26)

    val professor1 = Professor("Ben Matos")
    val professor2 = Professor("Flavio Abreu")

    val conteudo1 = ConteudoEducacional("Introdução a programação Kotlin", 60, professor1.nome)
    val conteudo2 = ConteudoEducacional("Avançando na Programação Kotlin", 120, professor2.nome)

    val cursoKotlin = Formacao("Curso de Kotlin Básico ao Avançado", Nivel.BASICO, listOf(conteudo1,conteudo2),)
    cursoKotlin.detalhes()
    cursoKotlin.matricular(usuario1)
    cursoKotlin.matricular(usuario2)

}