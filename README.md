# DentalClinicAdministration-SpringBootProject

Sistema de reserva de turnos

Se desea implementar un sistema que permita administrar la reserva de turnos
para una clínica odontológica. 
Los requerimientos que debe cumplir son los siguientes:

- Administración de datos de odontólogos: Agregar y modificar los datos de los odontólogos. Registrar apellido, nombre y matrícula de los mismos.
- Administración de pacientes: Registrar, modificar y eliminar los pacientes. De
cada uno se almacenan: nombre, apellido, domicilio, DNI, fecha de alta.
- Login: Validar el ingreso al sistema mediante un login con usuario y password.
Permitiendo a cualquier persona logueada registrar un turno pero solo a quienes
tengan un rol de administración poder gestionar odontólogos y pacientes.
- Registrar turno: Se tiene que poder permitir asignar a un paciente un turno con un
odontólogo a una determinada fecha y hora.
- Consultas: Mostrar en una grilla los turnos de la semana próxima indicando
nombre y apellido del odontólogo, nombre y apellido del paciente y día y hora del
turno.

Requerimientos técnicos:

La aplicación debe ser desarrollada en capas:
- Capa de presentación (MVC): Son las pantallas web que tendremos que
desarrollar utilizando el framework de Spring boot MVC con el template de
Thymeleaf y los controladores.
- Capa de negocio: Son las clases Java de nuestro negocio modelado a través
del paradigma orientado a objetos.
- Capa de acceso a datos (DAO/Repository): Son las clases que se encargaran
de acceder a la base de datos.
