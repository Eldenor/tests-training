I
Test Driven Development

1. Środkowa wartość tablicy
Napisz testy do metody która przyjmuje tablicę wartości int i zwraca środkową wartość.
Np. dla {5, 2, 1, 4, 3} będzie to 1, a dla {1, 2, 3, 4} będzie to 2. Dla pustej tablicy program zwróci -1. Do sortowania możemy wykorzystać metodę Arrays.sort().
Po napisaniu testów zaimplementuj tę metodę.
Po sprawieniu, że wszystkie testy będą działać postaraj się zrefaktoryzować kod, czyniąc go bardziej czytelnym.

2.String Calculator

	Zadanie to jest modyfikacją klasycznego "coding Kata":
	http://osherove.com/tdd-kata-1/
	http://www.peterprovost.org/blog/2012/05/02/kata-the-only-way-to-learn-tdd/

	KROK I
	1.  -> Napisz klasę, która zawiera metodę: int add(String numbers);
		-> Nie implementuj ciała tej metody (na razie :)
		-> metoda może przyjmować 0, 1 lub dwie liczby w postaci Stringa i musi zwracać ich sumę (dla pustego Stringa metoda zwraca 0)
			przykłady poprawnych parametrów: "", "1", "1,2"
	2. Zacznij od napisania najprostszych przypadków testowych. Najpierw napisz test, który działa dal pustego Stringa,
		a następnie dla Stringa zawierającego jedną liczbę, a następnie przejdź do napisania testu dla Stringa zawierającego
		dwie liczby
	3. Pamiętaj, żeby rozwiazywać rzeczy najprościej jak się da.
	4. Refaktoruj swój kod, tak jeżeli testy działają poprawnie.

	KROK II
	1. Pozwól aby kalkulator przyjmował Stringa, który zawiera może zawierać wiele liczb rozdzielonych przecinkiem

	KROK III
	1. Nie pozwól aby klakulator przyjmował Stringa, który zawiera liczby ujemne. Jeżli string zawiera liczby ujemne
		powinien być rzucony wyjątek IllegalArgumentExeption z wiadomością "negatives not allowed". Jeżli w stringu znajdują
		się wartości ujemne powinny być pokazane w wiadnomości wyjątku.

	KROK IV
	1. Liczby większe od 1000 są ignorowane. Np. dodawanie "2,1001" powinno zwrócić liczbę 2

II
Assercje
	1. Zrefaktoruj testy swoich klas tak aby używać adnotacji z AssertJ.

III
Mokowanie
	1. Napisz przypadki testowe dla ProductSerivce. Tym razem klasa ProduckStore powinna być mockiem, tak by testy
	były niezależne od siebie.