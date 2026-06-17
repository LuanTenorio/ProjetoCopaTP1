# ProjetoCopaTP1

Aplicação desktop em Java para gerenciamento da Copa do Mundo de 2026.


## Como rodar

Antes de executar, confirme que o JDK 21 (ou outra versão mais recente) está instalado:

```bash
java -version
```

No Windows, rode a aplicação com:

```bash
.\mvnw.cmd clean javafx:run
```

No Linux/macOS, rode:

```bash
./mvnw clean javafx:run
```

Também é possível abrir o projeto em uma IDE com suporte a Maven e executar a classe:

```text
com.github.luantenorio.projetocopatp1.Launcher
```

ou:

```text
com.github.luantenorio.projetocopatp1.HelloApplication
```

## Dados mockados

Para popular a aplicacao com dados iniciais, execute o `main` da classe:

```text
com.github.luantenorio.projetocopatp1.util.Mocking
```

Depois disso, execute a aplicacao normalmente e use um dos logins abaixo.

### Logins de teste

| Perfil | Email | Senha |
| --- | --- | --- |
| Administrador | `admin@copa.com` | `admin123` |
| Organizador | `organizer@copa.com` | `org2026` |
| Arbitro | `referee@copa.com` | `ref123` |

## Persistência local

A aplicação salva os dados em arquivos binários dentro da pasta do usuário:

```text
<home-do-usuario>/.projetocopatp1
```

No Windows, normalmente fica em:

```text
C:\Users\<seu-usuario>\.projetocopatp1
```

Se quiser reiniciar os dados, apague essa pasta e execute novamente o `main` da classe `Mocking`.
