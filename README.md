# jpa_rest_1
**Implementačná úloha 1.**  
Adresár dbapp1tb je maven projekt pre vývoj databázovej aplikácie. V balíku dbapp sú vytvorené entitné triedy podľa UML diagramu tried, zatiaľ bez JPA anotácií:

![image](https://github.com/user-attachments/assets/b6cc6d73-75ac-4325-a147-b3b5eec49d3c)

Úlohy
A) Triedy v balíku dbapp doplňte o JPA anotácie tak, aby z nich vygenerovaná databáza mala štruktúru znázornenú na relačnom diagrame:

![image](https://github.com/user-attachments/assets/611bb9a2-af04-41ab-9253-afbbcc6f3367)

Dôležité je aby vygenerované tabuľky mali presne tú istú štruktúru ako je uvedená v relačnom diagrame hore. (Názvy tabuliek, stĺpcov a ich typy musia byť zachované, na poradí stĺpcov nezáleží).
Stĺpec MENO v tabuľke OSOBA bude mať povinné a unikátne hodnoty.
Kľúčový stľpec ID môže (ale nemusí) byť autogenerovaný.

B) V balíku dbapp sa okrem entitných tried nachádza aj súbor DbApp.java obsahujúci deklaráciu metódy:  
&emsp;**Predmet novyPredmet( EntityManager em, String nazov, String meno ) throws Exception**  
Metóda slúži na vytvorenie nového predmetu v databáze, pričom dostane argumenty: manažér entít, názov predmetu a meno osoby, ktorá bude jeho prednášajúcim aj cvičiacim. 

Vašou úlohou je implementácia metódy **novyPredmet** podľa nasledujúcej špecifikácie:
- Metóda najprv preverí, či predmet so zadaným názvom už v databáze neexistuje.
  - Ak nie je zadaný názov predmetu, metóda neurobí nič, len vyhodí výnimku so správou chyba.
  - Ak predmet už existuje, metóda nerobí žiadne zmeny v databáze, len vyhodí výnimku so správou duplicita.
- Ak predmet s daným názvom neexistuje, vytvorí ho. (Ročník môže ostať prázdny)
- Ak je meno osoby zadané, vytvorí novú osobu s daným menom a urobí ju prednášajúcim aj cvičiacim novovytvoreného predmetu. (Ak nie je zadané, nový predmet ostane zatiaľ bez prednášajúceho aj cvičiacich.)
- Metóda vráti objekt novovytvoreného predmetu.

Odovzdajte balík dbapp zozipovaný ako súbor dbapp.zip

  
**Implementačná úloha 2.**  
V adresári restapp nájdete maven projekt pre vývoj webovej aplikácie s REST servisom.  
Projekt obsahuje:
- súbor pom.xml so všetkými závislosťami potrebnými pre vývoj servisu. Nie je ho potrebné dopĺňať.
- balík rest. V tomto balíku budete vytvárať všetky triedy (triedu implementujúcu servis aj dátovú/é triedu)  
  
**Špecifikácia servisu**  
&emsp;Servis bude poskytovať informácie o aktuálnom obedovom menu v rôznych jedálnach.  
Koreňový resource nazvite **jedalen**.  
Obedové menu na konkrétnej jedálne bude pristupné ako resource s URL **jedalen/{nazov}**  
kde nazov je identifikátor jedálne.  
Jednotlivé obedy v menu jedálne budú prístupné ako subresoursy s URL **jedalen/{nazov}/{n}**  
kde n je poradové číslo obedu v menu jedálne, pričom obedy sú číslované za sebou od 1.  

Pre URL **jedalen/{nazov}** implementujte metódy:  
- GET pre MIME text/plain: vráti aktuálny počet obedov v menu jedálne.  
Ak jedáleň s daným názvom neexistuje, vráti 0.  
- Post pre MIME application/xml: Pridá nový obed do menu danej jedálne.  
Akceptuje xml element jedlo so štruktúrou:  
&emsp;\<obed>  
&emsp;&emsp;\<meno>burger\</meno>  
&emsp;&emsp;\<cena>3.5\</cena>  
&emsp;\</obed>  
Metóda vráti poradové číslo nového obedu v menu jedálne (MIME text/plain).
Pozor. V menu jedálne by nemali byť dva obedy s rovnakým menom, preto by servis mal najprv skontrolovať, či obed s rovnakým menom už v menu jedálne nie je. Ak tam už je, nový obed nepridá ale vráti poradové číslo existujúceho obeda.  
Ak pre jedáleň s daným názvom ešte neexistuje (neobsahuje žiadne obedy), inicializuje ju.  

Pre URL **jedalen/{nazov}/{n}** implementujte metódy:
- GET pre MIME application/xml: Vráti informácie o obede s poradovým číslom n ako xml shoreuvedenou štruktúrou.
- DELETE: Odstráni obed s poradovým číslom n z menu danej jedálne.
Po odstránení obedu sa poradové čísla obedov za ním znížia.

**Implementácia servisu**
Všetky dáta budú udržiavané len v pamäti servisu. Vytvorte si pre dáta vhodné dátové štruktúry a (ak treba) dátové triedy. Použite anotáciu @javax.inject.Singleton. Nezabudnite tiež na anotáciu @XmlRootElement.
**Dôležité** - inicializácia servisu: Pri štarte si aplikácia inicializuje menu pre jedáleň s názvom BUFET, ktorá bude obsahovať jediný obed s menom burger a cenou 3.5.
Poznámky:
- Uvedené xml je len príklad, ktorý ilustruje požadovanú štruktúru. XML dokumenty, ktorými pracujeservis, majú elementy s rovnakými názvami a štruktúrou, odlišovať môžu len textovým obsahom.Poradie elementov nie je dôležité.
- Ak klient volá metódy pre neexistujúci resource, server nesmie vrátiť kód HTTP 50*
  
Odovzdajte balík rest zozipovaný ako súbor rest.zip
