PGDMP      .                |            yourticketdb    16.3    16.3 ^    '           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            (           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            )           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            *           1262    16541    yourticketdb    DATABASE     �   CREATE DATABASE yourticketdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE yourticketdb;
                postgres    false            �            1259    16677    tcheckin    TABLE     �   CREATE TABLE public.tcheckin (
    ckeckid integer NOT NULL,
    checkdate timestamp without time zone,
    teticket character varying(250),
    orderid integer
);
    DROP TABLE public.tcheckin;
       public         heap    postgres    false            �            1259    16676    tcheckin_ckeckid_seq    SEQUENCE     �   CREATE SEQUENCE public.tcheckin_ckeckid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tcheckin_ckeckid_seq;
       public          postgres    false    236            +           0    0    tcheckin_ckeckid_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tcheckin_ckeckid_seq OWNED BY public.tcheckin.ckeckid;
          public          postgres    false    235            �            1259    16562 	   tcustomer    TABLE     <  CREATE TABLE public.tcustomer (
    customerid integer NOT NULL,
    name character varying(30),
    lastname character varying(50),
    birthday date,
    country character varying(30),
    addres character varying(100),
    email character varying(50),
    phonenumber character varying(15),
    userid integer
);
    DROP TABLE public.tcustomer;
       public         heap    postgres    false            �            1259    16561    tcustomer_customerid_seq    SEQUENCE     �   CREATE SEQUENCE public.tcustomer_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tcustomer_customerid_seq;
       public          postgres    false    219            ,           0    0    tcustomer_customerid_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.tcustomer_customerid_seq OWNED BY public.tcustomer.customerid;
          public          postgres    false    218            �            1259    16666    teticket    TABLE     d   CREATE TABLE public.teticket (
    teticket character varying(250) NOT NULL,
    orderid integer
);
    DROP TABLE public.teticket;
       public         heap    postgres    false            �            1259    16588    tevent    TABLE     #  CREATE TABLE public.tevent (
    eventid integer NOT NULL,
    eventname character varying(100),
    information text,
    location character varying(250),
    eventday timestamp without time zone,
    status character varying(20),
    userid integer,
    eventimg character varying(150)
);
    DROP TABLE public.tevent;
       public         heap    postgres    false            �            1259    16587    tevent_eventid_seq    SEQUENCE     �   CREATE SEQUENCE public.tevent_eventid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tevent_eventid_seq;
       public          postgres    false    223            -           0    0    tevent_eventid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tevent_eventid_seq OWNED BY public.tevent.eventid;
          public          postgres    false    222            �            1259    16602 
   teventzone    TABLE     �   CREATE TABLE public.teventzone (
    zoneid integer NOT NULL,
    zonename character varying(20),
    ticketprice numeric(8,2),
    eventid integer
);
    DROP TABLE public.teventzone;
       public         heap    postgres    false            �            1259    16601    teventzone_zoneid_seq    SEQUENCE     �   CREATE SEQUENCE public.teventzone_zoneid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.teventzone_zoneid_seq;
       public          postgres    false    225            .           0    0    teventzone_zoneid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.teventzone_zoneid_seq OWNED BY public.teventzone.zoneid;
          public          postgres    false    224            �            1259    16638    torder    TABLE     �   CREATE TABLE public.torder (
    orderid integer NOT NULL,
    paymentmethod character varying(40),
    orderdate timestamp without time zone,
    status character varying(20),
    seatid integer,
    userid integer
);
    DROP TABLE public.torder;
       public         heap    postgres    false            �            1259    16637    torder_orderid_seq    SEQUENCE     �   CREATE SEQUENCE public.torder_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.torder_orderid_seq;
       public          postgres    false    231            /           0    0    torder_orderid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.torder_orderid_seq OWNED BY public.torder.orderid;
          public          postgres    false    230            �            1259    16655    torderhistory    TABLE     ]  CREATE TABLE public.torderhistory (
    orderhistoryid integer NOT NULL,
    paymentmethod character varying(40),
    eventdate timestamp without time zone,
    seatnumber integer,
    rowname character varying(10),
    zonename character varying(20),
    eventname character varying(100),
    location character varying(250),
    userid integer
);
 !   DROP TABLE public.torderhistory;
       public         heap    postgres    false            �            1259    16654     torderhistory_orderhistoryid_seq    SEQUENCE     �   CREATE SEQUENCE public.torderhistory_orderhistoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.torderhistory_orderhistoryid_seq;
       public          postgres    false    233            0           0    0     torderhistory_orderhistoryid_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.torderhistory_orderhistoryid_seq OWNED BY public.torderhistory.orderhistoryid;
          public          postgres    false    232            �            1259    16542    trole    TABLE     b   CREATE TABLE public.trole (
    roleid integer NOT NULL,
    description character varying(15)
);
    DROP TABLE public.trole;
       public         heap    postgres    false            �            1259    16614    trowzone    TABLE     t   CREATE TABLE public.trowzone (
    rowid integer NOT NULL,
    rowname character varying(10),
    zoneid integer
);
    DROP TABLE public.trowzone;
       public         heap    postgres    false            �            1259    16613    trowzone_rowid_seq    SEQUENCE     �   CREATE SEQUENCE public.trowzone_rowid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.trowzone_rowid_seq;
       public          postgres    false    227            1           0    0    trowzone_rowid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.trowzone_rowid_seq OWNED BY public.trowzone.rowid;
          public          postgres    false    226            �            1259    16626    tseatrow    TABLE     �   CREATE TABLE public.tseatrow (
    seatid integer NOT NULL,
    seatnumber integer,
    avalaible boolean,
    rowid integer
);
    DROP TABLE public.tseatrow;
       public         heap    postgres    false            �            1259    16625    tseatrow_seatid_seq    SEQUENCE     �   CREATE SEQUENCE public.tseatrow_seatid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tseatrow_seatid_seq;
       public          postgres    false    229            2           0    0    tseatrow_seatid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tseatrow_seatid_seq OWNED BY public.tseatrow.seatid;
          public          postgres    false    228            �            1259    16574    tseller    TABLE     7  CREATE TABLE public.tseller (
    sellerid integer NOT NULL,
    name character varying(100),
    information text,
    rfc character varying(20),
    country character varying(30),
    addres character varying(100),
    email character varying(50),
    phonenumber character varying(15),
    userid integer
);
    DROP TABLE public.tseller;
       public         heap    postgres    false            �            1259    16573    tseller_sellerid_seq    SEQUENCE     �   CREATE SEQUENCE public.tseller_sellerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tseller_sellerid_seq;
       public          postgres    false    221            3           0    0    tseller_sellerid_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tseller_sellerid_seq OWNED BY public.tseller.sellerid;
          public          postgres    false    220            �            1259    16548    tuser    TABLE     �   CREATE TABLE public.tuser (
    userid integer NOT NULL,
    username character varying(50),
    userpassword character varying(130),
    available boolean,
    roleid integer
);
    DROP TABLE public.tuser;
       public         heap    postgres    false            �            1259    16547    tuser_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.tuser_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.tuser_userid_seq;
       public          postgres    false    217            4           0    0    tuser_userid_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.tuser_userid_seq OWNED BY public.tuser.userid;
          public          postgres    false    216            X           2604    16680    tcheckin ckeckid    DEFAULT     t   ALTER TABLE ONLY public.tcheckin ALTER COLUMN ckeckid SET DEFAULT nextval('public.tcheckin_ckeckid_seq'::regclass);
 ?   ALTER TABLE public.tcheckin ALTER COLUMN ckeckid DROP DEFAULT;
       public          postgres    false    235    236    236            P           2604    16565    tcustomer customerid    DEFAULT     |   ALTER TABLE ONLY public.tcustomer ALTER COLUMN customerid SET DEFAULT nextval('public.tcustomer_customerid_seq'::regclass);
 C   ALTER TABLE public.tcustomer ALTER COLUMN customerid DROP DEFAULT;
       public          postgres    false    218    219    219            R           2604    16591    tevent eventid    DEFAULT     p   ALTER TABLE ONLY public.tevent ALTER COLUMN eventid SET DEFAULT nextval('public.tevent_eventid_seq'::regclass);
 =   ALTER TABLE public.tevent ALTER COLUMN eventid DROP DEFAULT;
       public          postgres    false    223    222    223            S           2604    16605    teventzone zoneid    DEFAULT     v   ALTER TABLE ONLY public.teventzone ALTER COLUMN zoneid SET DEFAULT nextval('public.teventzone_zoneid_seq'::regclass);
 @   ALTER TABLE public.teventzone ALTER COLUMN zoneid DROP DEFAULT;
       public          postgres    false    225    224    225            V           2604    16641    torder orderid    DEFAULT     p   ALTER TABLE ONLY public.torder ALTER COLUMN orderid SET DEFAULT nextval('public.torder_orderid_seq'::regclass);
 =   ALTER TABLE public.torder ALTER COLUMN orderid DROP DEFAULT;
       public          postgres    false    231    230    231            W           2604    16658    torderhistory orderhistoryid    DEFAULT     �   ALTER TABLE ONLY public.torderhistory ALTER COLUMN orderhistoryid SET DEFAULT nextval('public.torderhistory_orderhistoryid_seq'::regclass);
 K   ALTER TABLE public.torderhistory ALTER COLUMN orderhistoryid DROP DEFAULT;
       public          postgres    false    232    233    233            T           2604    16617    trowzone rowid    DEFAULT     p   ALTER TABLE ONLY public.trowzone ALTER COLUMN rowid SET DEFAULT nextval('public.trowzone_rowid_seq'::regclass);
 =   ALTER TABLE public.trowzone ALTER COLUMN rowid DROP DEFAULT;
       public          postgres    false    227    226    227            U           2604    16629    tseatrow seatid    DEFAULT     r   ALTER TABLE ONLY public.tseatrow ALTER COLUMN seatid SET DEFAULT nextval('public.tseatrow_seatid_seq'::regclass);
 >   ALTER TABLE public.tseatrow ALTER COLUMN seatid DROP DEFAULT;
       public          postgres    false    229    228    229            Q           2604    16577    tseller sellerid    DEFAULT     t   ALTER TABLE ONLY public.tseller ALTER COLUMN sellerid SET DEFAULT nextval('public.tseller_sellerid_seq'::regclass);
 ?   ALTER TABLE public.tseller ALTER COLUMN sellerid DROP DEFAULT;
       public          postgres    false    220    221    221            O           2604    16551    tuser userid    DEFAULT     l   ALTER TABLE ONLY public.tuser ALTER COLUMN userid SET DEFAULT nextval('public.tuser_userid_seq'::regclass);
 ;   ALTER TABLE public.tuser ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    217    216    217            $          0    16677    tcheckin 
   TABLE DATA           I   COPY public.tcheckin (ckeckid, checkdate, teticket, orderid) FROM stdin;
    public          postgres    false    236   sn                 0    16562 	   tcustomer 
   TABLE DATA           v   COPY public.tcustomer (customerid, name, lastname, birthday, country, addres, email, phonenumber, userid) FROM stdin;
    public          postgres    false    219   �n       "          0    16666    teticket 
   TABLE DATA           5   COPY public.teticket (teticket, orderid) FROM stdin;
    public          postgres    false    234   �o                 0    16588    tevent 
   TABLE DATA           o   COPY public.tevent (eventid, eventname, information, location, eventday, status, userid, eventimg) FROM stdin;
    public          postgres    false    223   �o                 0    16602 
   teventzone 
   TABLE DATA           L   COPY public.teventzone (zoneid, zonename, ticketprice, eventid) FROM stdin;
    public          postgres    false    225   p                 0    16638    torder 
   TABLE DATA           [   COPY public.torder (orderid, paymentmethod, orderdate, status, seatid, userid) FROM stdin;
    public          postgres    false    231   �p       !          0    16655    torderhistory 
   TABLE DATA           �   COPY public.torderhistory (orderhistoryid, paymentmethod, eventdate, seatnumber, rowname, zonename, eventname, location, userid) FROM stdin;
    public          postgres    false    233   �q                 0    16542    trole 
   TABLE DATA           4   COPY public.trole (roleid, description) FROM stdin;
    public          postgres    false    215   ir                 0    16614    trowzone 
   TABLE DATA           :   COPY public.trowzone (rowid, rowname, zoneid) FROM stdin;
    public          postgres    false    227   �r                 0    16626    tseatrow 
   TABLE DATA           H   COPY public.tseatrow (seatid, seatnumber, avalaible, rowid) FROM stdin;
    public          postgres    false    229   �r                 0    16574    tseller 
   TABLE DATA           p   COPY public.tseller (sellerid, name, information, rfc, country, addres, email, phonenumber, userid) FROM stdin;
    public          postgres    false    221    t                 0    16548    tuser 
   TABLE DATA           R   COPY public.tuser (userid, username, userpassword, available, roleid) FROM stdin;
    public          postgres    false    217   �t       5           0    0    tcheckin_ckeckid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tcheckin_ckeckid_seq', 1, true);
          public          postgres    false    235            6           0    0    tcustomer_customerid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tcustomer_customerid_seq', 2, true);
          public          postgres    false    218            7           0    0    tevent_eventid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tevent_eventid_seq', 3, true);
          public          postgres    false    222            8           0    0    teventzone_zoneid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.teventzone_zoneid_seq', 7, true);
          public          postgres    false    224            9           0    0    torder_orderid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.torder_orderid_seq', 8, true);
          public          postgres    false    230            :           0    0     torderhistory_orderhistoryid_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.torderhistory_orderhistoryid_seq', 8, true);
          public          postgres    false    232            ;           0    0    trowzone_rowid_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.trowzone_rowid_seq', 17, true);
          public          postgres    false    226            <           0    0    tseatrow_seatid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tseatrow_seatid_seq', 80, true);
          public          postgres    false    228            =           0    0    tseller_sellerid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tseller_sellerid_seq', 1, true);
          public          postgres    false    220            >           0    0    tuser_userid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tuser_userid_seq', 3, true);
          public          postgres    false    216            r           2606    16682    tcheckin tcheckin_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.tcheckin
    ADD CONSTRAINT tcheckin_pkey PRIMARY KEY (ckeckid);
 @   ALTER TABLE ONLY public.tcheckin DROP CONSTRAINT tcheckin_pkey;
       public            postgres    false    236            `           2606    16567    tcustomer tcustomer_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tcustomer
    ADD CONSTRAINT tcustomer_pkey PRIMARY KEY (customerid);
 B   ALTER TABLE ONLY public.tcustomer DROP CONSTRAINT tcustomer_pkey;
       public            postgres    false    219            p           2606    16670    teticket teticket_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.teticket
    ADD CONSTRAINT teticket_pkey PRIMARY KEY (teticket);
 @   ALTER TABLE ONLY public.teticket DROP CONSTRAINT teticket_pkey;
       public            postgres    false    234            d           2606    16595    tevent tevent_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tevent
    ADD CONSTRAINT tevent_pkey PRIMARY KEY (eventid);
 <   ALTER TABLE ONLY public.tevent DROP CONSTRAINT tevent_pkey;
       public            postgres    false    223            f           2606    16607    teventzone teventzone_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.teventzone
    ADD CONSTRAINT teventzone_pkey PRIMARY KEY (zoneid);
 D   ALTER TABLE ONLY public.teventzone DROP CONSTRAINT teventzone_pkey;
       public            postgres    false    225            l           2606    16643    torder torder_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.torder
    ADD CONSTRAINT torder_pkey PRIMARY KEY (orderid);
 <   ALTER TABLE ONLY public.torder DROP CONSTRAINT torder_pkey;
       public            postgres    false    231            n           2606    16660     torderhistory torderhistory_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.torderhistory
    ADD CONSTRAINT torderhistory_pkey PRIMARY KEY (orderhistoryid);
 J   ALTER TABLE ONLY public.torderhistory DROP CONSTRAINT torderhistory_pkey;
       public            postgres    false    233            Z           2606    16546    trole trole_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.trole
    ADD CONSTRAINT trole_pkey PRIMARY KEY (roleid);
 :   ALTER TABLE ONLY public.trole DROP CONSTRAINT trole_pkey;
       public            postgres    false    215            h           2606    16619    trowzone trowzone_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.trowzone
    ADD CONSTRAINT trowzone_pkey PRIMARY KEY (rowid);
 @   ALTER TABLE ONLY public.trowzone DROP CONSTRAINT trowzone_pkey;
       public            postgres    false    227            j           2606    16631    tseatrow tseatrow_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tseatrow
    ADD CONSTRAINT tseatrow_pkey PRIMARY KEY (seatid);
 @   ALTER TABLE ONLY public.tseatrow DROP CONSTRAINT tseatrow_pkey;
       public            postgres    false    229            b           2606    16581    tseller tseller_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tseller
    ADD CONSTRAINT tseller_pkey PRIMARY KEY (sellerid);
 >   ALTER TABLE ONLY public.tseller DROP CONSTRAINT tseller_pkey;
       public            postgres    false    221            \           2606    16553    tuser tuser_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tuser
    ADD CONSTRAINT tuser_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public.tuser DROP CONSTRAINT tuser_pkey;
       public            postgres    false    217            ^           2606    16555    tuser tuser_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.tuser
    ADD CONSTRAINT tuser_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.tuser DROP CONSTRAINT tuser_username_key;
       public            postgres    false    217            ~           2606    16688    tcheckin tcheckin_orderid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tcheckin
    ADD CONSTRAINT tcheckin_orderid_fkey FOREIGN KEY (orderid) REFERENCES public.torder(orderid);
 H   ALTER TABLE ONLY public.tcheckin DROP CONSTRAINT tcheckin_orderid_fkey;
       public          postgres    false    4716    231    236                       2606    16683    tcheckin tcheckin_teticket_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tcheckin
    ADD CONSTRAINT tcheckin_teticket_fkey FOREIGN KEY (teticket) REFERENCES public.teticket(teticket);
 I   ALTER TABLE ONLY public.tcheckin DROP CONSTRAINT tcheckin_teticket_fkey;
       public          postgres    false    234    4720    236            t           2606    16568    tcustomer tcustomer_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tcustomer
    ADD CONSTRAINT tcustomer_userid_fkey FOREIGN KEY (userid) REFERENCES public.tuser(userid);
 I   ALTER TABLE ONLY public.tcustomer DROP CONSTRAINT tcustomer_userid_fkey;
       public          postgres    false    217    4700    219            }           2606    16671    teticket teticket_orderid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.teticket
    ADD CONSTRAINT teticket_orderid_fkey FOREIGN KEY (orderid) REFERENCES public.torder(orderid);
 H   ALTER TABLE ONLY public.teticket DROP CONSTRAINT teticket_orderid_fkey;
       public          postgres    false    4716    231    234            v           2606    16596    tevent tevent_userid_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.tevent
    ADD CONSTRAINT tevent_userid_fkey FOREIGN KEY (userid) REFERENCES public.tuser(userid);
 C   ALTER TABLE ONLY public.tevent DROP CONSTRAINT tevent_userid_fkey;
       public          postgres    false    4700    223    217            w           2606    16608 "   teventzone teventzone_eventid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.teventzone
    ADD CONSTRAINT teventzone_eventid_fkey FOREIGN KEY (eventid) REFERENCES public.tevent(eventid);
 L   ALTER TABLE ONLY public.teventzone DROP CONSTRAINT teventzone_eventid_fkey;
       public          postgres    false    225    4708    223            z           2606    16644    torder torder_seatid_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.torder
    ADD CONSTRAINT torder_seatid_fkey FOREIGN KEY (seatid) REFERENCES public.tseatrow(seatid);
 C   ALTER TABLE ONLY public.torder DROP CONSTRAINT torder_seatid_fkey;
       public          postgres    false    229    231    4714            {           2606    16649    torder torder_userid_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.torder
    ADD CONSTRAINT torder_userid_fkey FOREIGN KEY (userid) REFERENCES public.tuser(userid);
 C   ALTER TABLE ONLY public.torder DROP CONSTRAINT torder_userid_fkey;
       public          postgres    false    217    4700    231            |           2606    16661 '   torderhistory torderhistory_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.torderhistory
    ADD CONSTRAINT torderhistory_userid_fkey FOREIGN KEY (userid) REFERENCES public.tuser(userid);
 Q   ALTER TABLE ONLY public.torderhistory DROP CONSTRAINT torderhistory_userid_fkey;
       public          postgres    false    4700    217    233            x           2606    16620    trowzone trowzone_zoneid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.trowzone
    ADD CONSTRAINT trowzone_zoneid_fkey FOREIGN KEY (zoneid) REFERENCES public.teventzone(zoneid);
 G   ALTER TABLE ONLY public.trowzone DROP CONSTRAINT trowzone_zoneid_fkey;
       public          postgres    false    4710    225    227            y           2606    16632    tseatrow tseatrow_rowid_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.tseatrow
    ADD CONSTRAINT tseatrow_rowid_fkey FOREIGN KEY (rowid) REFERENCES public.trowzone(rowid);
 F   ALTER TABLE ONLY public.tseatrow DROP CONSTRAINT tseatrow_rowid_fkey;
       public          postgres    false    227    229    4712            u           2606    16582    tseller tseller_userid_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.tseller
    ADD CONSTRAINT tseller_userid_fkey FOREIGN KEY (userid) REFERENCES public.tuser(userid);
 E   ALTER TABLE ONLY public.tseller DROP CONSTRAINT tseller_userid_fkey;
       public          postgres    false    217    4700    221            s           2606    16556    tuser tuser_roleid_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.tuser
    ADD CONSTRAINT tuser_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.trole(roleid);
 A   ALTER TABLE ONLY public.tuser DROP CONSTRAINT tuser_roleid_fkey;
       public          postgres    false    4698    217    215            $   G   x��� !��D�	`1�x���+��IE�%���0dm�j��Z���~�����z�����U^�LD?9�         �   x��ν
�0@���)��b�F�M�?Sq(��˥�%�4%�E}z�
������`�uq���3�{}�֝k�ű
�Q�#H������M�43�6^ӽ鑎����\mp(i�+��q�^����Xv��(-�*̝���Rʙ��L(`�?)�������?5��#~x8r	!wr$X�      "   4   x�KN�0336NԵLI1�5IM2�M�45�51162M6L227H�4����� ��
,         �   x�}���0E��+��RԨ
	�Q�_HŶ�����"�dr�s�s8����I���J������I	OY�XЂ���8��f4f$Z,�����n�U�!��h��QC{\[�q�J�`�Z��Mj�m�� Q�e΋�4$yy����h�?z�}���5>�7eJ�         A   x�3���4750�30�4�2��q����4�����1�2�Pc�e��������i����� ��*         �   x�u�Mj1�}�\`�%����L�2P�0	]���2�Ф������6����(OI'�'���I##�0�u����)S�r#m����b��7䀑�5*�Ȣ�!ȅ�������:/�E1y�Ry(sE�9�rN��6�ey_�:�}�8K�,�W��C�?N[�&b>�I���W!�/�&YS�Vv��7�o�:W�      !   �   x��н�0����U��� ����D� !.v` �R�^'H�3?�{8��J����`"XHF����4�����љ����6z;�jx[@kzM�c� AĲ���&�5駅��>ZU��]��H3��w�(���rq�W�̵$��쿳*T�ȍ3��?F�N�ځ�ǙFO�sC����         #   x�3�tt����2�v�2�v��2b���� ]�         I   x����PC�3)�������09��&l��֙�M���/���ුu1򆧜=r��o9;��w����         �   x�-��q�0�D0��#�7�_�!�bS��W[��-�6ڗ�j����}�O�g}�ܥ�i����>�(0�,��0��0��Gݹ��'?N|jh��޴��lߚ�����5����9���|�x�+��׫i���΀;��j��>���BEnT�JE�T��޵�_dA�ж�(���Ԏ��c���������,�P��$CI�u'J2��[O�y�����I��gsM         �   x�-�M
�@ ��x�-Qs�v�	F�.�h�fЇ<���C��Hݠ.V�.�}����!����v��ITT_q`���5� -�k������|�,48���N�4q��"�A��\
�w�Y(�@���Y���aK�#ȩѦ��;uÿߴ�&��܉������XF�@D���<�0 ;�         �   x����
�0  ����W�xTRQi���tYm��R6��/�����B�0ϝ��C�gʏ��NI�b�T^	z}U��[��b�J_���0# �|5-��υ���?���{�*l��Of�i`Ά�xR綎�H�F��ߔflZM<ۙO� �o�JG     