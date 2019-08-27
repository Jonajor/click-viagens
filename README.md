# desafio-clickbus
- [API-Heroku](#API Heroku)
- [Contrato-Api](#contrato)
- .[Model](#model)

# Banco de dados
O H2 é um banco de dados Open Source que funciona em memória com um console acessível pelo browser dentro do contexto da aplicação. Por ser um banco de configuração rápida e fácil, decidi utiliza-lo.

# End-Points:
# GetMapping:
Busca todos os locais: /clickBus/v1/places
Busca por ID: /clickBus/v1/{id}
Busca por cidade e estado: /clickBus/v1/place/getCityAndState/{city}/{state}
Busca por cidade: /clickBus/v1/places/getCity/{city}
Busca por nome: /clickBus/v1/places/getName/{name}
Busca por nome e cidade: /clickBus/v1/places/getNameAndCity/{name}/{city}

# Post
Cadastrar Local: /clickBus/v1/place
Content Type: application/json
Exemplo:
{
  "city": "string",
  "creationDate": "2019-08-27T01:23:38.270Z",
  "lesma": "string",
  "name": "string",
  "state": "string"
}

# PutMapping
Atualização: /clickBus/v1/{id}
Content Type: application/json
Exemplo:
{
  "city": "string",
  "creationDate": "2019-08-27T01:19:47.471Z",
  "lesma": "string",
  "name": "string",
  "state": "string",
  "updateDate": "2019-08-27T01:19:47.471Z"
}

# DeleteMapping
Exclusão: /clickBus/v1/{id}
Parameter: {id}

# API Heroku
Para utilizar os end-points da Api é necessário entrar no link abaixo e começar a fazer as chamadas nos end-points descritos a cima.
End-Point-heroku: https://gentle-basin-10620.herokuapp.com/swagger-ui.html#/

# Model
Place{
  city	string
  creationDate	string($date-time)
  id	integer($int32)
  lesma	string
  name	string
  state	string
  updateDate	string($date-time)
}

# contrato
{
    "swagger": "2.0",
    "info": {
        "description": "ClickBus Challenge",
        "version": "API TOS",
        "title": "Location Management API",
        "termsOfService": "Terms of service",
        "contact": {
            "name": "Jonathan Augusto Jorge",
            "email": "jonathan.augusto.jorge17@hotmail.com"
        },
        "license": {
            "name": "License of API",
            "url": "API license URL"
        }
    },
    "host": "gentle-basin-10620.herokuapp.com",
    "basePath": "/",
    "tags": [
        {
            "name": "place-controller",
            "description": "Place Controller"
        }
    ],
    "paths": {
        "/clickBus/v1/place": {
            "post": {
                "tags": [
                    "place-controller"
                ],
                "summary": "save",
                "operationId": "saveUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "in": "body",
                        "name": "place",
                        "description": "place",
                        "required": true,
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/place/getCityAndState/{city}/{state}": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "getByCityAndState",
                "operationId": "getByCityAndStateUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "city",
                        "in": "path",
                        "description": "city",
                        "required": true,
                        "type": "string"
                    },
                    {
                        "name": "state",
                        "in": "path",
                        "description": "state",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/places": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "findAll",
                "operationId": "findAllUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Place"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/places/getCity/{city}": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "getByCity",
                "operationId": "getByCityUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "city",
                        "in": "path",
                        "description": "city",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/places/getName/{name}": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "getByName",
                "operationId": "getByNameUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "name",
                        "in": "path",
                        "description": "name",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/places/getNameAndCity/{name}/{city}": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "getByNameAndCity",
                "operationId": "getByNameAndCityUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "city",
                        "in": "path",
                        "description": "city",
                        "required": true,
                        "type": "string"
                    },
                    {
                        "name": "name",
                        "in": "path",
                        "description": "name",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/clickBus/v1/{id}": {
            "get": {
                "tags": [
                    "place-controller"
                ],
                "summary": "getById",
                "operationId": "getByIdUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Optional«Place»"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            },
            "put": {
                "tags": [
                    "place-controller"
                ],
                "summary": "update",
                "operationId": "updateUsingPUT",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    },
                    {
                        "in": "body",
                        "name": "place",
                        "description": "place",
                        "required": true,
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Place"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            },
            "delete": {
                "tags": [
                    "place-controller"
                ],
                "summary": "delete",
                "operationId": "deleteUsingDELETE",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "object"
                        }
                    },
                    "204": {
                        "description": "No Content"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    }
                },
                "deprecated": false
            }
        }
    },
    "definitions": {
        "Optional«Place»": {
            "type": "object",
            "properties": {
                "present": {
                    "type": "boolean"
                }
            },
            "title": "Optional«Place»"
        },
        "Place": {
            "type": "object",
            "properties": {
                "city": {
                    "type": "string"
                },
                "creationDate": {
                    "type": "string",
                    "format": "date-time"
                },
                "id": {
                    "type": "integer",
                    "format": "int32"
                },
                "lesma": {
                    "type": "string"
                },
                "name": {
                    "type": "string"
                },
                "state": {
                    "type": "string"
                },
                "updateDate": {
                    "type": "string",
                    "format": "date-time"
                }
            },
            "title": "Place"
        }
    }
}
