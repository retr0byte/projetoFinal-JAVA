CREATE TABLE IF NOT EXISTS categoria (
     cd_Categoria serial PRIMARY KEY,
     nm_Categoria varchar(50) not null
);

CREATE TABLE IF NOT EXISTS autor (
     cd_autor serial PRIMARY KEY,
     nm_autor varchar(50) not null
);

CREATE TABLE IF NOT EXISTS contato (
     cd_contato serial PRIMARY KEY,
     nm_cliente  varchar(50) not null,
     ds_emailCliente varchar(255) not null,
     cd_telefoneCliente varchar(16) not null,
     ds_mensagem text not null
);

CREATE TABLE IF NOT EXISTS livro (
     cd_livro serial PRIMARY KEY,
     nm_livro varchar(255) not null,
     ds_livro text not null,
     cd_autor int not null,
     cd_categoria int not null,
     FOREIGN KEY (cd_autor) REFERENCES autor (cd_autor),
     FOREIGN KEY (cd_categoria) REFERENCES categoria (cd_categoria)
);
