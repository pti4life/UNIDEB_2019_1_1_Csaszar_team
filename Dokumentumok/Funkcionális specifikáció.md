# Lottószimulátor Projekt

## Funkcionális specifikáció

## 1. Vezetői összefoglaló

Ennek a programnak a célja a tudatos lottózásra való ösztönzés illetve szimplán csak a szórakozás, kíváncsiság. <br> 
Felmerülő problémák:
  * Szerencsejáték szenvedély kialakulása a lottózással kapcsolatosan.
  * A játékosok már nem szórakozás, hanem pénzszerzési lehetőséget látnak
   a lottó típusú játékokban.
  * A lottózók nem kapnak statisztikát arról, hogy mennyit költenek 
    és mennyit nyereséget hoz nekik a szerencsejáték így hajlamosabbak
    a mértéktelen játékra.

A program részben megoldást biztosíthat ezekre a problémákra. A játékos
egy virtuális környezetben tudja szimulálni a "lottózást" és egyidőben
látja a megtett szelvények darabszámát, ennek megfelően a játékra
költött pénzt, a nyert össszeget, a hasznot és egyéb "real-time" statisztikákat.
Fontos, hogy a személyek akiknél szerencsejáték függöség alakult ki, ne csak
a lottózók által tipikusan hangsúlyozott, statisztikával találkozzon miszerint a 
nyerési esély például 1:3.362.260 -hoz (skandináv lotto nyerési esélyei) , hanem 
egyéb komplex, a lottózok által nem publikált adatokat, és statiszikákat is megkapjon.
Ezek az adatok látva a játékos könnyebben levonhatja azt a konzekvenciát miszerint
a lottózás alkalmatlan pénzkeresésre.

## 2. Jelenlegi helyzet

A szerencsejáték mindig is egy veszélyes hobbi volt, nemhiába szigorúan
18 éves kor felettiek vehetik igénybe, és az állam legútobbi szigorítása, miszerint
csak kézpénzel vásárolható lottószelvény sem segített a kialakult helyzeten .
Ameddig a szerencsejátékra egy hobbiként,szórakozásként tekintünk 
és nem pénzszerzési lehetőségként tekintünk rá addig csekély 
az esély függőség kialakulására. Mindenesetre a kóros játékszenvedély 
komoly anyagi romlást idézhet elő, megváltozik a függő személyisége és a 
környezetére is rossz hatással lehet. Mindezek ellenére sokan látják ebben a gyors 
meggazdagosás lehetőségét, viszont statisztikailag látható, hogy erre nagyon kevés az esély.
Tehát miután, a lottozás és egyéb szerencsejátékok, csak szorakazási célból működnek 
egészségesen egy ember életében, így nincs semmi értelme valós pénz elköltésére.
Programunk pontosan ezt a problémakört érinti, és erre nyújt megoldást, az által, hogy 
a felhasználó valós pénz költése nélkül ( eltekintve az alkalmazás  vételi árától ), részt
vehessen ugyanabban az addiktív élményben amit a lottózás nyújt.

## 3. Vágyálom rendszer

* A program grafikus interfészén lehetőség lesz átváltani egy "statisztikák" menüpontra, 
  ahol oszlop- és vonaldiagramok vizualizálják az eddigi eredményeket napra/hétre/hónapra lebontva.
* Az ablak egyik sarkában egy számláló lesz elhelyezve, amely egy előre megadott értéken kezd és 
  a felhasználónak lehetősége lesz ezt feltenni a játékokra. Az számláló negatív értéket
  is felvehet egy bizonyos pontig, ezzel szemléltetve az adósságot.
* A játszani kívánt lottó fajtáját egy legörülő menüből lehessen kiválasztani, 
  a feltenni kívánt számokat pedig szövegdobozokban.
* Magát a program kódját pedig tisztán és átláthatóan kell megírni, kommenteléssel a későbbi 
  változtatásokhoz megfelelő leírást adni.

## 4. Jelenlegi üzleti folyamatok


## 5. Igényelt üzleti feladatok

A rendszer használatához regisztrálni kell, <br>
  Név <br>
  Felhasználói név <br>
  jelszó megadásával.

* A felhasználó belépés után 4 ablakból választhat (új szelvény, történet, 
statisztika, mennyit kell vennem?)
* Az "új szelvény" ablak bekér egy paramétert (a vásárolni kívánt szelvények
száma). Az érték megadása után megjelenít két kalkulált adatot (a szelvények
árát, a felhasználó pénzét). A képernyőn megjelenik még a szelvények ára,
valamint egy gomb "Vásárlás" felirattal. Ha a felhasználó megnyomja, meg kell
erősítenie a felugró ablakon. Amint megerősítette, megjelenik a "Sorsolás
gomb". Ezt megnyomva generálunk a beállításoknak megfelelő mennyiségű számot. 
Majd megjelenik, hogy nyert-e a felhasználó.
* A "történet" ablak tartalmaz egy táblát, amit az adatbázisból lekért adatokkal
tölt fel. A táblázatnak négy oszlopa van, amik a következők: tranzakció dátum,
megvásárolt szelvények száma, szelvényekért fizetett összeg, nyereség(lehet,
negatív).
* A "statisztika" ablak a következő adatokat tartalmazza: az összes eddig
megvásárolt szelvény száma, az összes eddig elköltött pénz, a nyertes szelvények
száma, a vesztes szelvények száma. Ha marad idő, kördiagrammal megjelíteni,
így az arányok is láthatóak.
* A "mennyit kell vennem?" ablak kérjen be egy számot, az input mező után
legyen egy choice box, ahol ki tudja választani a felhasználó, hogy darab
számot szeretne megadni, vagy esélyt. Egy gomb megnyomása után megjelenik
a kalkulált szám (értelemszerűen darabszámból esélyt számol, és fordítva).
* Minden ablakon megjelenik egy gomb, amely segítségével vissza tud lépni a 
felhasználó a belépés utáni ablakra.
* A biztonság kedvéért legyen valahol egy "Kapcsolatok fül". Itt a cég elérhetőségei
jelenjenjenek meg (e-mail, weboldal, telefon). Valamint jelezzük, hogy ez 
hibák jelzésére szolgál.
* Minden ablak tartalmaz egy "Kilépés gombot", ha a felhasználó megnyomja,
akkor meg kell erősíttenie egy felugró ablakon, hogy ki szeretne lépni.
* Az ablak nem újraméretezhető, így könnyeb jó design-t készíteni hozzá.
* Minden ablak tartalmazhat valamilyen dekor elemet (pl: a rendelő logója,
a rendelő neve, a program logója).