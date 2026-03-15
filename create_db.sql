
    create table administrativos (
        id bigint not null,
        cargo varchar(100) not null,
        primary key (id)
    ) engine=InnoDB;

    create table citas (
        fecha_hora datetime(6) not null,
        id bigint not null auto_increment,
        medico_id bigint not null,
        paciente_id bigint not null,
        motivo varchar(500) not null,
        observaciones varchar(1000),
        estado enum ('CANCELADA','CONFIRMADA','PENDIENTE','REALIZADA') not null,
        primary key (id)
    ) engine=InnoDB;

    create table departamentos (
        numero_planta integer check ((numero_planta>=0)),
        id bigint not null auto_increment,
        especialidad varchar(100),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table enfermeros (
        id bigint not null,
        area varchar(100),
        turno enum ('MANANA','NOCHE','TARDE'),
        primary key (id)
    ) engine=InnoDB;

    create table habitaciones (
        ocupada bit,
        precioDia float(53) not null check ((precioDia>=0)),
        departamento_id bigint,
        id bigint not null auto_increment,
        numero varchar(255) not null,
        tipo enum ('DOBLE','INDIVIDUAL','QUIROFANO','UCI'),
        primary key (id)
    ) engine=InnoDB;

    create table historiales (
        fecha date not null,
        id bigint not null auto_increment,
        paciente_id bigint not null,
        diagnostico varchar(1000) not null,
        observaciones varchar(2000),
        primary key (id)
    ) engine=InnoDB;

    create table ingresos (
        activo bit,
        fecha_alta datetime(6),
        fecha_ingreso datetime(6) not null,
        habitacion_id bigint not null,
        id bigint not null auto_increment,
        paciente_id bigint not null,
        motivo varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    create table medicamentos (
        stock integer not null check ((stock>=0)),
        id bigint not null auto_increment,
        nombre varchar(100) not null,
        principio_activo varchar(200) not null,
        primary key (id)
    ) engine=InnoDB;

    create table medicos (
        id bigint not null,
        firma varchar(255),
        numero_colegiado varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table pacientes (
        activo bit,
        fecha_nacimiento date,
        grupo_sanguineo varchar(5),
        id bigint not null auto_increment,
        telefono varchar(20),
        nombre varchar(100) not null,
        direccion varchar(200),
        dni varchar(255) not null,
        email varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table personal_medico (
        activo bit,
        fecha_contratacion date not null,
        departamento_id bigint not null,
        id bigint not null auto_increment,
        telefono varchar(20),
        especialidad varchar(100),
        nombre varchar(100) not null,
        email varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tratamiento_medicamento (
        duracion_dias integer check ((duracion_dias>=1)),
        medicamento_id bigint not null,
        tratamiento_id bigint not null,
        dosis varchar(100) not null,
        frecuencia varchar(255) not null,
        primary key (medicamento_id, tratamiento_id)
    ) engine=InnoDB;

    create table tratamientos (
        activo bit,
        fecha_fin date,
        fecha_inicio date not null,
        historial_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table habitaciones 
       add constraint UK17jgtlfmwr92ca32wlsgyrh7h unique (numero);

    alter table medicos 
       add constraint UKbovkuwggu2yadna32b0ijitsn unique (numero_colegiado);

    alter table pacientes 
       add constraint UKhol387x0ourgruynyqewdhv37 unique (dni);

    alter table pacientes 
       add constraint UKa83ft0lfk8ltx47ve931qw2kq unique (email);

    alter table personal_medico 
       add constraint UKd7cfubqxjw7qw003pq682rtj7 unique (email);

    alter table administrativos 
       add constraint FK3py8t6pc3p0vlrom845mlgfxj 
       foreign key (id) 
       references personal_medico (id);

    alter table citas 
       add constraint FKbfl57ey8hx1a3ubtrpy8x9ll 
       foreign key (medico_id) 
       references medicos (id);

    alter table citas 
       add constraint FKnqrsxxcuysfcxiekvixm7h8r1 
       foreign key (paciente_id) 
       references pacientes (id);

    alter table enfermeros 
       add constraint FKp1ouf8tfe5a1l7w3iguqrrei3 
       foreign key (id) 
       references personal_medico (id);

    alter table habitaciones 
       add constraint FKj34x8m8e9q3prl0i7ejfxbhc3 
       foreign key (departamento_id) 
       references departamentos (id);

    alter table historiales 
       add constraint FKhkmjm25qe9radd98clvv6xwei 
       foreign key (paciente_id) 
       references pacientes (id);

    alter table ingresos 
       add constraint FKl2fghrh94lmi25nv2io2sf3y7 
       foreign key (habitacion_id) 
       references habitaciones (id);

    alter table ingresos 
       add constraint FK6rge1a6e6wy1cv9421p5lqq81 
       foreign key (paciente_id) 
       references pacientes (id);

    alter table medicos 
       add constraint FKpk53gio1enxrk7w41lf6cdikk 
       foreign key (id) 
       references personal_medico (id);

    alter table personal_medico 
       add constraint FK32eh7qbskxbvmjsprgo7tlcrn 
       foreign key (departamento_id) 
       references departamentos (id);

    alter table tratamiento_medicamento 
       add constraint FKac91jurtn2ev21ktwdne1fjn7 
       foreign key (medicamento_id) 
       references medicamentos (id);

    alter table tratamiento_medicamento 
       add constraint FK34ku27eeahcd3opcqkm1r4ai1 
       foreign key (tratamiento_id) 
       references tratamientos (id);

    alter table tratamientos 
       add constraint FKn7uqkuhhihbulssikjrb1d5tu 
       foreign key (historial_id) 
       references historiales (id);
