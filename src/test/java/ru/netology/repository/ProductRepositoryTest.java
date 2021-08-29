package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Product homer = new Product(56, "theOdyssey", 1200);
    private Smartphone iPhone = new Smartphone();

    @Test
    public void shouldSaveOneBook() {               // проверяем что книга является продуктом
        repository.save(coreJava);                  // сохраняем книгу в репозиторий продукта

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {         // проверяем что смартфон является продуктом
        repository.save(iPhone);                    // сохраняем смартфон в репозиторий продукта

        Product[] expected = new Product[]{iPhone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {                // проверяем метод удаления по Id
        repository.save(homer);
        repository.save(iPhone);                    // добавили два продукта
        repository.removeById(56);                  // удалили продукт homer

        Product[] expected = new Product[]{iPhone}; // остался продукт iPhone
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}