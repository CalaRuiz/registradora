CREATE TABLE Asociado(

       nombre VARCHAR(20),
       PRIMARY KEY (nombre)
    
);


CREATE TABLE Registradora(
       Id INTEGER,
       Id_Asociado VARCHAR(20),
       Fecha DATE,
       PRIMARY KEY (Id),
       FOREIGN KEY(Id_Asociado)REFERENCES Asociado(nombre)

   
);