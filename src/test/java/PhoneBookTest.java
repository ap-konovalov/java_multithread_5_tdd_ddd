import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneBookTest {
    private PhoneBook PHONE_BOOK = null;

    @BeforeEach
    void init() {
        PHONE_BOOK = new PhoneBook();
    }

    @Test
    void addShouldReturnCountOfContacts() {
        int actualCountOfContacts = PHONE_BOOK.add("Alex", "89035542345");
        assertEquals(1, actualCountOfContacts);
    }

    @Test
    void addShouldNotAddDuplicateNames() {
        String duplicatedName = "Alex";
        PHONE_BOOK.add(duplicatedName, "89035542345");
        int actualCountOfContacts = PHONE_BOOK.add(duplicatedName, "5553535");
        assertEquals(1, actualCountOfContacts);
    }

    @Test
    void findByNumberShouldReturnNameIfExists() {
        String expectedName = "Alex";
        String existingPhone = "5554433";
        PHONE_BOOK.add(expectedName, existingPhone);
        String foundName = PHONE_BOOK.findByNumber(existingPhone);
        assertEquals(expectedName, foundName);
    }

    @Test
    void findByNumberShouldReturnEmptyStringIfPhoneNotExists() {
        String notExistingPhone = "5554433";
        String foundName = PHONE_BOOK.findByNumber(notExistingPhone);
        assertTrue(foundName.isBlank());
    }

    @Test
    void findByNameShouldReturnPhoneIfExists() {
        String existingName = "Alex";
        String expectedPhone = "5554433";
        PHONE_BOOK.add(existingName, expectedPhone);
        String foundPhone = PHONE_BOOK.findByName(existingName);
        assertEquals(expectedPhone, foundPhone);
    }

    @Test
    void findByNameShouldReturnEmptyStringIfNameNotExists() {
        String notExistingName = "Random";
        String foundPhone = PHONE_BOOK.findByName(notExistingName);
        assertTrue(foundPhone.isBlank());
    }

    @Test
    void printAllNamesShouldReturnAllNamesInAlphabetOrder() {
        String firstName = "A";
        String secondName = "B";
        String thirdName = "D";
        String fourthName = "C";
        PHONE_BOOK.add(secondName, "2");
        PHONE_BOOK.add(firstName, "1");
        PHONE_BOOK.add(thirdName, "4");
        PHONE_BOOK.add(fourthName, "3");
        Set<String> actualResult = PHONE_BOOK.printAllNames();
        Set<String> expectedSortedNamesSet = Set.of(firstName, secondName, thirdName, fourthName);
        assertTrue(actualResult.equals(expectedSortedNamesSet));
    }
}
