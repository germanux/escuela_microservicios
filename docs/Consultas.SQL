SELECT * FROM db_usuarios.tema_de_usuario 
	INNER JOIN usuario ON usuario.id = tema_de_usuario.id_usuario
 WHERE tema_de_usuario.id_usuario = 2;
 
SELECT tema.* FROM db_usuarios.tema_de_usuario 
	INNER JOIN usuario ON usuario.id = tema_de_usuario.id_usuario
    INNER JOIN tema ON tema.id = tema_de_usuario.id_tema
 WHERE tema_de_usuario.id_usuario = 2;