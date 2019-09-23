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

* <b>Üzleti szereplők:</b> 
	csakis azon felhasználók akik használják a programot 

* <b>Üzleti folyamatok:</b>
	A megtett számokat beolvassuk és random generált számmokkal összvetve a felhasználónak
    megjelenítjük az elért eredményt.
    A lejátszott játékokról pontok és adatok tárolása.
	Az adatok alapján statisztikát és grafikonokat jelenítünk meg.

			FELHASZNÁLÓ                   
			|		                  			
			|                        
			\|/	  /	                 
		SORSOLÁS -------------------------|
			|	  \		           |	
			|			           |	  
			\|/			           | 	   	
		FELHASZNÁLÓ DÖNT, HOGY                | 
		KILÉP VAGY FOLYTATJA   ----folytatja--|
			|
			|
			|
			|
			|
			k
			i
			l
			é
			p
			|
			|
			|
			\|/
		PROGRAM BEZÁRÓDIK

* <b>Üzleti entitások:</b>
	JTextField: itt adják meg a felhasználók a megtenni kívánt számokat<br>
	JTextPane: az adott játék eredménye, pontok mennyiségének változása.<br>
	JButton: statisztika mód és fő panel közötti váltása. megtett számok véglegesítése<br>
	JComboBox: játékmód kiválasztása<br>
	Jfreechart: grafikonok vizualizálása<br>



## 4. Követelmények: 
* Funkcionális követelmények:
	* A számításokban nem lehet hiba
	* Minden input lekezelve, minden lehetséges beérkező adatra
	* Minden lehetséges Exception lekezelve, nem fagyhat ki a program
* Nem funkcionális követelmények:
	* A felhasználói felület könnyen kezelhető legyen
	* Semmilyen felesleges adat nem kerül megjelenítésre
* Jogi követelmények:
	* A szerencsejátékokra szóló törvények figyelembe vétele


## 5. Funkcionális terv:

* <b>Képernyőtervek:</b> A felhasználó az ablak alján lévő mezőben adhatja meg a megtenni kívánt számokat és 
    a mellette lévő gombbal véglegesítheti és új szelvény kérni. A szelvény eredményét a középen lévő dobozban láthatja, 
    a nyert vagy vesztett pontok és eltalált számokkal egyetemben. A játékválasztó gomb segítségével 
	a különböző lottó fajták közül választhat a felhasználó.
	A jobb felül elhelyezkedő statisztika és történet gombokon átvált a felhasználó statisztikikáihoz, 
	ahol az eddig megnyert és elvesztett pontokat, találatokat és oszlopdiagrammokat láthat.

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
