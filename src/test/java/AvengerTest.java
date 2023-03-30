import com.bnpp.bcefit.lafabrique.saison7.avengers.Humanoid;
import com.bnpp.bcefit.lafabrique.saison7.avengers.ListOfHero;
import com.bnpp.bcefit.lafabrique.saison7.avengers.SuperHero;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class TestUtil {
    public static void displayMethod() {
        Thread t = Thread.currentThread();
        String otherInfo = t.getClass().getName();

        String methodName = otherInfo + "." + t
                .getStackTrace()[2]
                .getMethodName();

        System.out.print(methodName + "() ");
    }


}


public class AvengerTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=================== Début des tests AvengerTest ===================");
        // ici, on peut déclarer des variables ou récupérer des jeux de données
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("=================== Fin des tests AvengerTest ===================");
        // ici, on peut nettoyer ce qui a pu être fait pendant les tests. Par exemple supprimer des fichiers
        // ou des enregistrements de test
    }

    @BeforeEach
    public void debutTest() {
        System.out.print("Début du test... ");
    }

    @AfterEach
    public void finTest() {
        System.out.println("Fin du test. ");
    }

    private static final int AGE_MINEUR = 17;

    @Test
    public void test_should_spiderman_estmineur() {
        TestUtil.displayMethod();

        SuperHero spiderman = ListOfHero.spiderman;

        assertThat(spiderman.getAge()).isLessThanOrEqualTo(AGE_MINEUR);

    }

    @Test
    public void test_should_blackWidow_beAnAvenger() {
        //Assertions.assertThat(ListOfHero.blackWidow).isIn(ListOfHero.avengers);
        //Assertions.assertThat(ListOfHero.avengers.indexOf(ListOfHero.blackWidow)).isPositive();
        assertThat(ListOfHero.avengers).contains(ListOfHero.blackWidow);

    }


    @Test
    public void test_should_avengers_haveEachSuperheroOnlyOnce() {
        //Assertions.assertThat(ListOfHero.avengers).containsOnlyOnceElementsOf(ListOfHero.avengers);
        assertThat(ListOfHero.avengers).doesNotHaveDuplicates();
    }

    @Test
    public void test_should_thanos_notBeAnAvenger() {
        assertThat(ListOfHero.avengers).doesNotContain(ListOfHero.thanos);
    }

    @Test
    public void test_should_thorAndThanos_have_noSuperHeroName() {
        // deux méthodes de tests séparés seraient mieux.
        assertThat(ListOfHero.thor.getNomSuperHero()).isNull();
        assertThat(ListOfHero.thanos.getNomSuperHero()).isNull();
    }

    @Test
    public void test_should_thanos_haveHulkPowers() {
        assertThat(ListOfHero.thanos.getPowers()).containsAll(ListOfHero.hulk.getPowers());
    }

    @DisplayName("HawkEye shold be an instance of SuperHero and of Humanoid, but ClintonBarton is neither a SuperHero or a String")
    @Test
    public void test_should_ex7() {
        assertThat(ListOfHero.hawkEye).isInstanceOf(SuperHero.class);
        assertThat(ListOfHero.hawkEye).isInstanceOf(Humanoid.class);
        assertThat(ListOfHero.clintonBarton).isNotInstanceOf(SuperHero.class);
        assertThat(ListOfHero.clintonBarton).isNotInstanceOf(String.class);
    }

}
