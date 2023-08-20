import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

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
}
