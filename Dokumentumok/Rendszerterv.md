# Lottószimulátor Projekt

## 1. A rendszer célja: 
	
A program célja a lottózással párhuzamba hozható szenvedélybetegség megelőzése. 
A felhasználók szimulálhatnak tetszőleges számú "lottó játékot" (számok választása - sorsolás) 
ezáltal saját magukon tapasztalhatják meg, hogy a lottózás inkább alkalmas jelentős
mennyiségű pénz elveszítésére mintsem pénzkeresésre, mivel egyidőben
látják a megtett szelvények darabszámát, ennek megfelelően a játékra
költött pénzt, a nyert össszeget, a hasznot és egyéb "real-time" statisztikákat. 
Ezek mellett a program célja a tudatos lottózásra való ösztönzés illetve szimplán 
csak a szórakozás, kíváncsiság. 

## 2. Projekt terv: 


### Projekt szerepkörök, felelősségek, erőforrások:
A projekt elkészítésért 4 junior programozó felelős, (Kállai Roland, Bodnár Csaba, Szűcs Gergő, Hidi Erik Zoltán), a szerepkörök, felelősségek a specifikálásra kerülnek a továbbiakban. A projekt kisméretűségéből adódóan, a szerepkörök között átfedések lehetnek.

<b>Front End fejlesztő:</b><br> 
Szűcs Gergő, Bodnár Csaba: Az alkalmazás kinézetéért felelős szakember, a front end megjeleníti az információt a felhasználónak.
	
<b>Back End fejlesztő:</b><br> 
Kállai Roland, Hidi Erik Zoltán: A szerveren futó logika megírásáért felel pl.: Üzleti logika, Adatbázis modell.

A <b>tesztelést</b> tekintettel a kis projektre nem nevezünk ki külön embert, egymás között megosztva tesztelünk.
			

### Ütemterv, Mérföldkövek:
1. A projekt 2019.09.09.-én kezdődött, és a határidő 2019.09.30.
	A szoftver implementációjára és teljes teszteleséig hátralévő időszak 14 nap. 

2. A dokumentáció elkészítése 2019.09.23-ra befejezésre kerül, ekkora elérhetőek a következő dokumentumok:
	a, Követelmény specifikáció
	b, Funkcionális specifikáció
	c, Jelenleg is még folyamatban lévő rendszerterv

3. 2019.09.30-ra elérhető a teljes rendszer tesztelve, átadás megegyezés szerint 2019. szeptember 30.-a után.
			

## 3. Üzleti folyamatok modellje: 

   * **Megvalósítandó üzleti folyamatok:**
     * Regisztráció/bejelentkező rendszer biztosítása.
     * A programban lehetőség legyen lottójátékok szimulálására. A felhasználó kiválasztja a számait ezután sorsolás gombra kattintva megtörténik a sorsolás.
	 * Maguk a felhasználók, illetve az adatai hosszú idejú strukturált módon való tárolása Oracle SQL relációs adatbázisban.

![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9pek/Regisztr%C3%A1ci%C3%B3.jpg)
![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9pek/LOTT%C3%93Z%C3%81S.jpg)

   * **Üzleti Szereplők**
     * Azon felhasználók akik használják a programot.
   * **Üzleti Entitások**
             
     * <b>User</b>:A felhasználót reprezentáló perzisztens objektum.<br>
	 Az objektum váza:
             
       |User|
       |------|
       |int(ID)|
       |String(name)|
       |String(username)|
       |String(password)|



## 4. Követelmények: 
* Funkcionális követelmények:
	* A számításokban nem lehet hiba, azaz helyes input értékek megadása
  esetén helyes értéket ad a program.
	* Minden input lekezelve, minden lehetséges beérkező adatra, azaz, amennyiben
  a felhasználó nem megfelelő értéket ad meg hibaüzenet segítségével jelezzük,
  hogy hibás valamelyik érték. Ezt követően újra lehet próbálkozni értékadással.
* Nem funkcionális követelmények:
	* A felhasználói felület könnyen kezelhető legyen az idősebb korosztály
  számára is, valamint a számítógépek terén nem tapasztalt felhasználók
  számára is. Ennek az elérésehez egyszerű, letisztult grefikus felhasználói
  felületet kell terveznünk.
	* Semmilyen felesleges adat nem kerül megjelenítésre, ezzel is elkerülve
  a felhasználó esetleges összezavarását.
* Jogi követelmények:
	* Mivel nem valós pénzt használ a felhasználó, ezért a szoftver nem 
  minősül szerencsejátéknak, így az arra vonatkozó szigorú törvényeknek
  sem kell megfelelnie.
  * A felhasználóról tárolt adatokat TILOS kiadni, valamint manipulálni!


## 5. Funkcionális terv:

* <b>Képernyőtervek:</b></br>
  <b>új szelvény:</b></br>
  ![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9perny%C5%91terv/%C3%9Aj%20szelv%C3%A9ny.png)</br>
  A képernyő bal felső sarkában két indormáció jelenik meg: a szelvények jelenlegi
  ára és a felhasználó birtokában lévő kreditmennyiség. A felhasználó megadhatja
  a vásárolni kívánt szelvény mennyiséget, a fizetendő összeg megjelenik melette.
  A vásárlás gombra kattintva, a fizetendő összeg levonódik a kredit mennyiségből,
  valamint a felhasználó ki kell töltse a vásárolt szelvényeket.</br>
  <b>történet:</b></br>
  ![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9perny%C5%91terv/Statisztika.png)</br>
  A képernyőn megjelenik egy táblanézet. A táblázatban a felhasználó számlatörténtete
  jelenik meg, amit az adatbázisból kérün le.</br>
  <b>statisztika:</b></br>
  ![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9perny%C5%91terv/T%C3%B6rt%C3%A9net.png)</br>
  **SZERKESZTÉSRE VÁR**</br>
  <b>mennyit kell vennem?:</b></br>
  ![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9perny%C5%91terv/Mennyit%20kell%20vennem.png)</br>
  A felhasználó két kalkuláció közül tud választani:
  - Meg tudja adni a vásárolt szelvények számát, ekkor megkapja mennyi esélye 
  van a nyerésre (5 találatra, ha minden szelvényen más variációt adott meg). 
  - Meg tudja adni mennyi esélyt szeretne elérni, ekkor megkapja hány szelvényt
  kellene vásárolnia, hogy elérje az adott esélyt.

## 6. Fizikai környezet: 
   
  Az alkalmazás JavaFX platformon kerül megvalósításra ennek következtében a 
  végeredmény egy asztali alkalmazás lesz. A megvalósítás Intellij Community
  Netbeans, Eclipse fejlesztői környezetek használatával történik.
  Az alkalmazás fejlesztése során csak is open source függőségeket tartalmazhat. 
  Mivel a szoftver nem csatlakozik hálózathoz ezért tűzfal vagy egyéb hálózattal 
  kapcsolatos tudnivaló nincs. Az alkalmazás futtatásához szükséges a Java 11-es
  verziója és mivel Java-ról beszélünk ezért az alkalmazás teljes mértékben platformfüggetlen.

## 7. Absztrakt domain modell: 
* Domain specifikáció, fogalmak
* Absztrakt komponensek, ezek kapcsolatai

## 8. Architekturális terv:

## 9. Adatbázis terv: 
  A Debreceni Egyetem Informatika Karja biztosítja számunkra az adatbázis
  szervert. Ez a szerver egy ORACLE SQL adatbázis környezetet futtat. A tervek
  szerint mindössze egy táblára van szükség az adatok tárolásához. Az említett
  tábla modellje:

  ![](https://github.com/pti4life/UNIDEB_2019_1_1_Csaszar_team/blob/master/Dokumentumok/K%C3%A9pek/Lottery_User.svg)

  Oszlopok leírása:
  *<b>ID:</b> </br>
  automatikusan generált <b>int</b> érték. Nem lehet NULL, ez a Primary 
  Key. Nem létezhet több egyforma.
  *<b>user_name:</b> </br>
  a felhasználó által választott név, később szükséges a bejelentkezéshez. 
  <b>Varchar</b> érték, ami nem lehet NULL, valamint nem egyezhet más felhasználó 
  nevével.
  *<b>pass:</b> </br>
  a felhasználó által megadott jelszó Hash-elt értéke, ami <b>varchar</b>  típusként 
  van eltárolva. Nem lehet NULL.
  *<b>bought_tickets:</b> </br>
  a felhasználó által vásárolt szelvények száma. <b>Int</b> típus, kezdőértéke 0.
  *<b>winner_tickets:</b> </br>
  a felhasználó által vásárolt nyertes szelvények száma. <b>Int</b> típus, 
  kezdőértéke 0. 
  *<b>credit:</b> </br>
  a rendelkezésre álló kredit mennyiség. <b>Int</b> típus, kezdőértéke 1000. 
  Az érték 24 óránként növekszik 300 kredittel.
  *<b>credit_used_up:</b> </br>
  a felhasználó által elköltött kredit mennyiség. <b>Int</b> típus, kezdőértéke 0.
  *<b>credit_won:</b> </br>
  kredit mennyiség, amit a felhasználó a nyertes szelvények segítségével nyert. 
  *<b>Int</b> típus, kezdőértéke 0.
  *<b>credit_lost:</b> </br>
  kredit mennyiség, amit a felhasználó a vesztes szelvények vásárlási költsége miatt 
  vesztett. <b>Int</b> típus, kezdőértéke 0.


## 10. Implementációs terv: 
  * Menüpontok leírása:
  * <b>új szelvény:</b>
Kérje be a program, hogy: hány darab szelvényt venne a felhasználó, mennyi
pénzbe fog ez kerülni, valamint mennyi pénz áll a rendelkezésére. Legyen megtalálható 
még egy vétel gomb, amit megnyomva kérdezzen rá a program, hogy biztos-e a
vételben a felhasználó. Ha igennel válaszol, akkor a rendelkezésre álló
összeg az új összeg legyen megjelenítve.
  * <b>történet:</b>
Táblázatban jelenjenek meg az addig lezajlott tranzakciók. A táblában a következő
adatok szerepeljenek: a tranzakció dátuma, a szelvények száma, fizetett összeg,
nyereség (ha veszített, az aktuális tranzakcióban vásárolt szelvényeken, akkor 
a vesztett pénzösszeg jelenjen meg "-" jelzővel).
* <b>statisztika:</b>
A képernyőn meg kell hogy jelenjenek a következő adatok: összesen eddig
megvásárolt szelvények száma, összesen eddig elköltött pénz, a nyertes szelvények
száma, a vesztes szelvények száma, összes eddig nyereség, valamint az eddig veszteségek.
Ezeket az adatokat valamilyen diagram segítségével ábrázolni is kell, amennyiben 
belefér a határidőbe.
* <b>mennyit kell vennem?:</b>
Ez a fül tartalmazzon egy kalkulátort, ami kiszámolja hány darab szelvényt
kell vennie a felhasználónak, hogy x% (felhasználó által adott érték) esélye
legyen nyerni valamelyikkel, ha mindegyiken más kombinációt adott meg.
Ez a folyamat működjön két irányban, azaz, ha a felhasználó az a darabszámot
adja meg, akkor jelenjen meg mennyi esélye van nyerni.

## 11. Tesztterv: 

* <b>Komponensteszt</b></br>
A komponens és integrációs tesztet idő hiányában egy lépésben fedjük le. Itt a legfontosabbnak ítélt metódusok, osztályok és azok közös működését teszteljük.
Ezeknek a leírását és a teszt végeredményét pedig a következő táblázatban ábrázoljuk:



|Metódus neve   |Metódus leírása   |Elvárt működés   |Teszt állapota   |
|---------------|------------------|-----------------|-----------------|
|  login |Bejelentkezési adatokat az adatbázisból lekéri és kiértékeli |Minden eshetőségre van elágazás |Nincs megkezdve   |


* <b>Rendszerteszt</b></br>
A közeli határidő miatt a rendszertesztet nincs lehetőség külön céghez kiszervezni. Ez házon belül lesz megoldva, ahol a csapat minden tagja külön átfutja a rendszertervet és az ott specifikált funkciókat teszteli és dokumentálja a problémákat.
* <b>Átvételi teszt</b></br>
A program átvételi tesztjét egy limitált létszámú bétateszt keretein belül valósítjuk meg. Ezen közeli ismerősöknek és egyetemi társaknak küldünk ki egy próbaverziót. A teszt fő célja a bejelentkezési felület megfelelő működésének és az adatbázis teherbírásának felmérése.