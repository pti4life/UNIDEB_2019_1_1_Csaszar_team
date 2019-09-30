# Lottószimulátor Projekt

## Követelményspecifikáció

## 1. Vezetői összefoglaló

A program célja a lottózással párhuzamba
hozható szenvedélybetegség megelőzése azáltal hogy a felhasználó szembesül a lottózás mögött rejlő pontos statisztikával, ami úgy van megkonstruálva, hogy nyeresége csak is kizárólag a lottózás mögött álló cégnek legyen.<br>
A program felhasználói szimulálhatnak 
tetszőleges számú "lottó játékot" (számok választása - sorsolás) ezekkel az a cél, hogy
saját magukon tapasztalják meg, hogy a lottózás inkább alkalmas jelentős
mennyiségű pénz elveszítésére mintsem pénzkeresésre és a statisztikából bármilyen érdekes információkat következtessenek, szűrjenek ki.  


## 2. Jelenlegi helyzet

A szerencsejáték mindig is egy veszélyes hobbi volt, nemhiába szigorúan
18 éves kor felettiek vehetik igénybe, és az állam legutobbi szigorítása, miszerint
csak készpénzel vásárolható lottószelvény sem segített a kialakult helyzeten. Az emberek amíg nem látják maguk előtt összesítve azt a pénzt amit elbuktak, és nincsenek tisztában azzal, hogy mennyire kevés esélyük van nyerni addig hajlamosak felelőtlenül, folyamatosan lottózni. Erre is megoldást nyújthat a Lottószimulátor. <br>
Ameddig a szerencsejátékra egy hobbiként, szórakozásként tekintünk 
és nem pénzszerzési lehetőségként tekintünk rá addig csekély 
az esély függőség kialakulására. Mindenesetre a kóros játékszenvedély 
komoly anyagi romlást idézhet elő, megváltozik a függő személyisége és a 
környezetére is rossz hatással lehet. Mindezek ellenére sokan látják ebben a gyors 
meggazdagodás lehetőségét, viszont statisztikailag látható, hogy erre nagyon kevés az esély.


## 3. Vágyálom rendszer

* Egy olyan egyértelmű és átlátható user interface megalkotása, ahol a 
 felhasználó különböző statisztikákon láthatja elért eredményeit 
 napra/hétre/hónapra lebontva.
* Pontrendszer: a valódi pénz leváltása valamilyen játékbeli valutára.
* A játékos statisztikát kaphat arról, hogy hány szelvényt kellene megtegyen
 ahoz, hogy egy bizonyos százalékú esélye legyen nyerni. ( pl 100.000 szelvény esetén, 3.2%-os esély )
* Többfajta lottó játékból való választás lehetösége (ötöslottó, hatoslottó, euro jackpot),
 ezáltal lehetővé téve, hogy a felhasználó kedvenc játékát szimulálja.
* Megbízható és hatékony program létrehozása személyi számítógépre.
* A programot úgy kell elkészíteni, hogy a későbbi esetleges bővítésre mindig lehetőség legyen.
* Olyan élvezeti funkciók, ami miatt érdemes használni a programot lottózás helyett. 

## 4. Jelenlegi üzleti folyamatok

Abban az esetben, ha mégis megnyeri valaki egy lottó főnyereményét azt nagyrészük hamar
elkölti, nagyon kevesen fektetnek be vagy teszik félre kamatozni. Így nem elég, hogy a
nyerés esélye hihetetlenül kicsit, még ha az ember el is viszi a fődíjat maximum néhény
évig javul tőle jelentősen az élete. 

## 5. Igényelt üzleti feladatok

Elsősorban a rendszernek bejelentkezéssel védettnek kell lennie, a bejelentkezés regisztrációhoz kötött, tehát aki használni kívánja a programot annak regisztrálnia - majd bejelentkeznie kell.

Igényelnénk egy "welcome" ablakot, ahol a felhasználónak választania kell 
a fülek közül: 
* új szelvény
* történet
* statisztika
* mennyit kell vennem?

Valamint ezek mellet a képernyőn még meg kell jelennie valahol egy vissza a
kezdőlapra gombnak, ami a welcome ablakot hozza vissza. Ezek mellett minden 
panelt/ablakot dekorálhatja a cég logója.
Fülek leírása:
* új szelvény:
 Kérje be a program, hogy: hány darab szelvényt venne a felhasználó, mennyi pénzbe fog ez kerülni, valamint mennyi pénz áll a rendelkezésére. Legyen megtalálható még egy vétel gomb, amit megnyomva kérdezzen rá a program, hogy biztos-e a vételben a felhasználó. Ha igennel válaszol, akkor a rendelkezésre álló összeg az új összeg legyen megjelenítve.

* statisztika:
A képernyőn meg kell hogy jelenjenek a következő adatok: összesen eddig
megvásárolt szelvények száma, összesen eddig elköltött pénz, a nyertes szelvények
száma, a vesztes szelvények száma, összes eddig nyereség, valamint az eddig veszteségek.
Ezeket az adatokat valamilyen diagram segítségével ábrázolni is kell, amennyiben 
belefér a határidőbe.

* mennyit kell vennem?:
Ez a fül tartalmazzon egy kalkulátort, ami kiszámolja hány darab szelvényt
kell vennie a felhasználónak, hogy x% (felhasználó által adott érték) esélye
legyen nyerni valamelyikkel, ha mindegyiken más kombinációt adott meg.
Ez a folyamat működjön két irányban, azaz, ha a felhasználó az a darabszámot
adja meg, akkor jelenjen meg mennyi esélye van nyerni.
