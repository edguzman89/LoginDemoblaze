Feature: Validación del Proceso de Autenticación en una Plataforma Web
          Yo Como usuario,
          quiero registrarme en la plataforma,
          para poder acceder a la funcionalidad completa de la misma.

          Yo Como usuario,
          quiero poder iniciar sesión con mis credenciales,
          para acceder a mi cuenta

  Background:
    Given que el usuario está en la página de inicio

  @Scenario1
  Scenario Outline: Registro de usuario exitoso
    When el usuario da clic en la opcion Sign up donde se desplega un pop up
    And el usuario ingresa <usuario> en el campo Username y <password> en el campo Password dar clic en el botón Sign up
    Then el usuario vera un mensaje que indica Sign up successful.

    Examples:
    | usuario | password  |
    | Pepitus | pass1234  |
    | Pabluto | pass5678  |
    | Carluto | pass9012  |


  Scenario Outline: Inicio de sesión exitoso
    When el usuario dara clic en la opcion Log in donde se desplega un pop up
    And aqui el usuario ingresa <usuarios> en campo Username y <passwords> en campo Password dar clic en el botón Sign up
    Then el usuario ingresa a su pagina y vera un mensaje que indica Welcome <usuarios>

    Examples:
      | usuarios  | passwords   |
      | Pepitus   | pass1234    |
      | Pabluto   | pass5678    |
      | Carluto   | pass9012    |


  Scenario: Inicio de sesión por credenciales inválidas
    When el usuario dara clic en la opcion Log in donde se desplega un pop up
    And aqui el usuario ingresa Pepitus en campo Username y zzz en campo Password dar clic en el botón Sign up
    Then el usuario vera un mensaje que indica Wrong password.

  Scenario: Error en el inicio de sesión con cuenta no registrada
    When el usuario dara clic en la opcion Log in donde se desplega un pop up
    And aqui el usuario ingresa katalina945 en campo Username y katalina945 en campo Password dar clic en el botón Sign up
    Then el usuario vera un mensaje que indica User does not exist.