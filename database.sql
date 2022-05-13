--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanici" (
    "KullaniciID" integer NOT NULL,
    "KullaniciAdi" text NOT NULL,
    "Ad" text NOT NULL,
    "Soyadı" text NOT NULL,
    sifre text NOT NULL
);


ALTER TABLE public."Kullanici" OWNER TO postgres;

--
-- Name: Kullanici_KullaniciID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Kullanici_KullaniciID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Kullanici_KullaniciID_seq" OWNER TO postgres;

--
-- Name: Kullanici_KullaniciID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Kullanici_KullaniciID_seq" OWNED BY public."Kullanici"."KullaniciID";


--
-- Name: Kullanici KullaniciID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici" ALTER COLUMN "KullaniciID" SET DEFAULT nextval('public."Kullanici_KullaniciID_seq"'::regclass);


--
-- Data for Name: Kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanici" VALUES (1, 'esra_unal', 'Esra', 'Unal', '111');
INSERT INTO public."Kullanici" VALUES (2, 'furkan_unal', 'Furkan', 'Unal', '222');


--
-- Name: Kullanici_KullaniciID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Kullanici_KullaniciID_seq"', 9, true);


--
-- Name: Kullanici Kullanici_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "Kullanici_pkey" PRIMARY KEY ("KullaniciID");


--
-- Name: Kullanici unique_Kullanici_KullaniciAdi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "unique_Kullanici_KullaniciAdi" UNIQUE ("KullaniciAdi");


--
-- Name: Kullanici unique_Kullanici_KullaniciID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "unique_Kullanici_KullaniciID" UNIQUE ("KullaniciID");


--
-- PostgreSQL database dump complete
--

