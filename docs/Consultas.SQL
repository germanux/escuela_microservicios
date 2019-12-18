USE db_usuarios;

SELECT tu.* FROM db_usuarios.tema_de_usuario AS tu
	INNER JOIN db_usuarios.usuario AS u ON u.id = tu.id_usuario
 WHERE tu.id_usuario = 2;
 
SELECT tema.* FROM tema_de_usuario 
    INNER JOIN tema ON tema.id = tema_de_usuario.id_tema
 WHERE tema_de_usuario.id_usuario = 2;
 