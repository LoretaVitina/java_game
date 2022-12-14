# Spēles dokumentācija
### Spēles apraksts
Spēlējot spēli, lietotājam ir iespējams ne tikai pārbaudīt savas zināšanas,
bet vienlaikus arī uzlabot savas spējas atminēt visas pasaules valstu galvaspilsētas,
jo pie katra nepareizi atbildēta jautājuma tiek norādīta pareizā atbilde.
Tāpat ir iespējams salīdzināt iegūto rezultātu ar saviem iepriekšējiem rezultātiem
vai citu spēlētāju iegūtajiem rezultātiem, jo pēc katras spēles tiek izprintēts rezultātu tops, 
kur parādās iegūtā vieta 
un pareizi atbildēto jautājumu skaits.
### Datu avotu apraksts
Spēlē tiek izmantoti divi veidu datu avoti: dati no csv failiem un konsolē ievadītā informācija. 
Spēlē tiek izmantoti sekojoši faili:
1. valstu csv fails, kur iekļautas visas pasaules valstis un to galvaspilsētas.
No šī faila tiek ielasītas visas valstis un to galvaspilsētas, kurām galvaspilsētu kolonnā nav norādīts 
*N/A* un kuras neatrodas Antarktīdā;
2. rezultātu csv fails, kurā pēc katras spēles tiek ielasīts
spēlētāja lietotājvārds, iegūtie punkti un spēlē pavadītais laiks, un no kura
tiek atgriezts visu rezultātu tops. 

Spēlētājam spēles laikā konsolē ir jāievada: 
1. savs lietotājvārds, kas tiek saglabāts spēlētāja (*Player*) klasē un izmantots,
lai personificētu spēli, veidojot spēlētājam redzamās teksta izdrukas, kā arī parādītu spēlētāja rezultātu rezultātu topā;
2. atbilžu varianti (proti, A, B, C vai D), norādot izvēlēto variantu atbildei uz jautājumu *What is capital of some random country?*. Ja spēlētājs nospiež *ENTER*, neievadot atbilžu variantu, tad spēlētajam tiek atgādināts par pareizās atbildes ievadi, vienlaicīgi atņemot vienu dzīvību.
### Rezultātu apraksts
Uzsākot spēli, spēlētājs tiek informēts par spēles noteikumiem. Proti, spēlētājam tiek piešķirtas 10 dzīvības, bet nopelnīto punktu skaits ir nulle. 
Ievadot pareizo atbildi konsolē, spēlētājs tiek informēts, ka ir saņēmis vienu punktu, 
kā arī tiek izprintēts kopējais iegūto punktu skaits. Savukārt, ja spēlētājs ievada nepareizu atbildi, tad saņem izdruku konsolē, ka ir zaudējis vienu dzīvību,
un saņem informāciju par atlikušo dzīvību skaitu. Pēc visu 10 dzīvību *iztērēšanas* spēle tiek pabeigta, un spēlētājs konsolē saņem informāciju par to, 
cik punktu kopā ir saņēmis un cik ilgs ir bijis viņa spēles laiks, kā arī spēlētājam konsolē tiek parādīts rezultātu tops.
### Spēles koda struktūra
Spēles kods ir rakstīts programmēšanas valodā "Java". Kods ir strukturēts sešās klasēs, kur katra klase
atbild par atsevišķu funkciju veikšanu:
1. Valsts(*Country*) klase atbild par valstu un galvaspilsētu datu ielasīšanu no csv faila, visu ielasīto valstu saraksta izveidošanu un četru nejauši atlasītu valstu ģenerēšanu;
2. Spēlētāja (*Player*) klase atbild par spēlētāja vārda uzstādīšanu, punktu, dzīvību un spēles laika izsekošanu;
3. Jautājuma (*Question*) klase atbild par atbilžu variantu izveidošanu un attēlošanu, kā arī pareizās atbildes noteikšanu un pārbaudi;
4. Rezultāta (*Result*) klase atbild par katra rezultāta ielasīšanu csv failā, visu spēļu rezultātu atgūšanu no minētā faila, kā arī rezultātu topa atspoguļošanu;
5. Rezultātu salīdzināšanas (*ResultComparator*) klase rezultāta klasē no csv faila ielasītos spēļu rezultātus sakārto dilstošā secībā, izmantojot burbuļa kārtošanas (*Bubble sort*) metodi. Ja divi spēlētāji ir ieguvuši vienādu punktu skaitu, tad augstāku vietu iegūst tas spēlētājs, kurš spēli ir pabeidzis īsākā laikā.
6. Hronometra (*Stopwatch*) klase, kas uzņem spēles laiku sekundēs. Hronometra klase ir saistīta ar spēlētāja klasi.
### Secinājumi par progresu kursā
Uzsākot kursu "Programmēšanas pamati I" pašmācības ceļā biju gan pašmācības ceļā apguvusi visvienkāršākās tēmas, piemēram,
vienkāršos datu tipus, cilpas un datu masīvus, gan arī mācījusies kursu "Programmatūras testēšana". Neskatoties uz to, kursa laikā ne tikai tika nostiprinātas jau iepriekš iegūtās zināšanas,
 bet arī iegūtas ļoti daudz jaunas zināšanas un prasmes. Lai arī mans progress kursā nav tik straujš,
kā tas būtu apgūstot visu kursa vielu no *nulles*, tomēr tas ir ievērojams. Manuprāt, vislielākais ieguvums ir spēja mazāk paļauties
uz *if-else* blokiem, izvairīties no *Makaroni* koda veidošanas un veidot izmantot gudrākus risinājumus.


