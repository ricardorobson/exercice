version: '3'
services:
    api-server:
        container_name: exercice
        image: exercice:latest
        expose:
            - 8080
        ports:
            - 80:8080
        networks:
            - swan
        depends_on:
            - postgresBD
        restart: on-failure

    postgresBD:
        container_name: postgresauth
        image: postgres:10.4
		expose:
            - 5432
        ports:
            - 5432:5432
        environment:
            -  POSTGRES_DB=database
            -  POSTGRES_USER=postgres
            -  POSTGRES_PASSWORD=root
        volumes:
            - postgres:/var/lib/postgresql/data
        networks:
            - swan
        depends_on:
            - eureka-server

networks:
    swan:
	    driver: bridge
volumes:
   postgres: