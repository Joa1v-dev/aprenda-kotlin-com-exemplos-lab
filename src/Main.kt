import java.text.Normalizer

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String, val idade: Int)

data class Professor(val nome: String)

data class ConteudoEducacional(var nome: String,
                               val duracao: Int = 60,
                               val professor: Professor
)

data class Formacao(val nome: String,
                    val nivel: Nivel,
                    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    val tempoCurso: Int
        get() = conteudos.sumOf { it.duracao }

    val tempoFormatado: String
        get() {
            val horas = tempoCurso / 60
            val minutos = tempoCurso % 60
            return "${horas}h ${minutos}min"
        }

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} foi adicionado ao curso ${nome}.\n")
    }

    fun detalhes() {
        println("\n==================================")
        println("  Curso: $nome")
        println("  Nível: $nivel")
        println("  Duração total do curso: $tempoFormatado")
        println("  Conteúdos:")
        conteudos.forEachIndexed { index, conteudo ->
            println("    ${index + 1}.${conteudo.nome}")
            println("    Duração: ${conteudo.duracao} min")
            println("    Professor: ${conteudo.professor.nome}\n")

        }
        if (inscritos.isNotEmpty()) {
            println("Inscritos: ")
            inscritos.forEach { println(" - ${it.nome} (${it.email})") }
        }
        println("--------------------------------\n")
    }
}

// funções auxiliares

fun criarUsuarios() = listOf(
    Usuario("João Victor Alexandre", "joao@email.com",22),
    Usuario("Layla Carvalho", "laylac@email.com",26),
    Usuario("Lucas Santos", "lucass@email.com", 30),
    Usuario("Paulo Silva", "paulos@email.com", 23),
    Usuario("Ana Costa", "anac@email.com",29)
)

fun criarProfessores() = listOf(
    Professor("Ben Matos"),
    Professor("Flavio Abreu"),
    Professor("Raimundo Sousa"),
    Professor("Camila Andrade"),
    Professor("Silvana Lima")
)

fun criarCursos(professor: List<Professor>): List<Formacao> {
    val conteudosKotlin = listOf(
        ConteudoEducacional("Introdução à Programação Kotlin",60, professor[0]),
        ConteudoEducacional("Avançando na Programação Kotlin", 120, professor[1]),
        ConteudoEducacional("Desafio de Projeto Kotlin", 90, professor[0]),
        )

    val conteudosJava = listOf(
        ConteudoEducacional("Introdução a Linguagem Java", 120, professor[3]),
        ConteudoEducacional("Avançando na Linguagem Java", 180, professor[3]),
    )

    val conteudosWeb = listOf(
        ConteudoEducacional("Programação Web com HTML e CSS", 140, professor[4]),
        ConteudoEducacional("Programação Web Aprendendo JavaScript", 120, professor[4])
    )


    return listOf(
        Formacao("Kotlin Básico ao Avançado", Nivel.INTERMEDIARIO, conteudosKotlin),
        Formacao("Java Básico ao Avançado", Nivel.DIFICIL, conteudosJava),
        Formacao("Programação Web", Nivel.BASICO, conteudosWeb)

    )
}



fun criarCurso(nome: String, nivel: Nivel, conteudos: List<ConteudoEducacional>) : Formacao {
    return Formacao(nome, nivel, conteudos)
}


fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val professores = criarProfessores()
    val usuarios = criarUsuarios()
    val cursos = criarCursos(professores)

    val cursoKotlin = cursos[0]
    val cursoJava = cursos[1]
    val cursoWeb = cursos[2]

    cursoKotlin.matricular(usuarios[0])
    cursoKotlin.matricular(usuarios[1])

    cursoWeb.matricular(usuarios[2])
    cursoWeb.matricular(usuarios[3])

    cursoJava.matricular(usuarios[4])

    cursos.forEach { it.detalhes() }
}