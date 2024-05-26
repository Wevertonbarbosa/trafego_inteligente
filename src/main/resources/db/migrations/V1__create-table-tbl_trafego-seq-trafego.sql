CREATE SEQUENCE TBL_TRAFEGO_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_TRAFEGO(
    ID INTEGER DEFAULT TBL_TRAFEGO_SEQ.NEXTVAL NOT NULL,
    VEICULO VARCHAR(100) NOT NULL,
    TAMANHO_ONIBUS VARCHAR(50) NOT NULL,
    PLACA VARCHAR(25) NOT NULL,
    RG_ONIBUS VARCHAR(20) NOT NULL,
    HORA_SAIDA VARCHAR(20) NOT NULL,
    ROTA_SAIDA VARCHAR(20) NOT NULL,
    HORA_CHEGAR VARCHAR(20) NOT NULL,
    ROTA_CHEGADA VARCHAR(20) NOT NULL
)