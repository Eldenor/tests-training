# Testy jednostkowe

1. Dokończ implementację metod kalkulatora. Uzupełnij go o metody odejmowania i mnożenia. Napisz testy jednostkowe dla
tych metod.
    W trakcie pisania testów wykonaj eksperymenty z adnotacjami JUnit 5 (https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations) tj.
    * @RepeatedTest
    * @DisplayName
    * @BeaforeEach/@AfterEach
    * @Disabled

2. Zaimplementuj i przetestuj funkcjonalność systemu zarządzającego sklepem internetowym.
     * W pakiecie services znajduje się klasa Product. Skończ implementować tą klasę. Zadecyduj czy chcesz aby cena produktu
		wyrażona była w typie BigDouble, czy może Money.  https://www.baeldung.com/java-money-and-currency
	 * ProduktStore reprezentuje bazę danych produktów. Zawiera ona mapę produktów, gdzie ich kluczem jest unikalna liczba całkowita
	    Skończ implementację klasy ProductStore dopisz metody, które pozwalają na dodawanie, usuwanie, modyfikowanie produktu.
	 * ProductService zawiera użyteczne metody, które pozwalają na modyfikację zawartości product

	 * !!! Napisz testy jednostkowe dla klasy ProductService

# Testy parametryzowane

1. Napisz testy parametryzowane dla kalkulatora oraz dla ProductService. Postaraj się wykorzystać wszystkie poznane możliwości
dostarczania danych do testów parametryzowanych.
    * @ValueSource
    * @MethodSource
    * @CsvSource
    * @ArgumentSource


# Testowanie wyjątków

1. Dodaj do klasy "Calculator" metodę która dzieli dwie liczby całkowite. W jakim przypadku wykoaninie metody zakończy się wyjątkiem?
   Napisz testy jednostkowe dla metody dzielenia.

2. Zastanów się, co jakie są przypadki graniczne dla klasy kalkulator. Zastanów się jak metody z klasy Math takie jak toIntExact, addExact, subtractExact
   mogą być przydatne w pisaniu klakulatora.

2. Napisz metodę addProduct i removeProduct, tak by zamiast wartości boolean wyrzucany był wyjątek jeżeli operacja nie powiedzie się sukcesem.
   Napisz testy jednostkowe, testujące zachowanie rzucanych wyjątków.