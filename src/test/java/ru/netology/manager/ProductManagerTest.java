package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Book coreJava = new Book();
    private Product homer = new Product(56, "theOdyssey", 1200);
    private Smartphone iPhone = new Smartphone();

    @Test
    public void shouldGetAll() {               // проверяем что книга является продуктом

        manager.add(coreJava);  //!NPE         // сохраняем книгу в репозиторий продукта

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
}
