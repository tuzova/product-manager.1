package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book Dubliners = new Book(124, "Dubliners", 1000, "Joyce");
    private Smartphone iPhoneSE20 = new Smartphone(1003, "iPhoneSE20", 44900, "Apple");

    @Test
    public void shouldSaveOneBook() {
        repository.save(Dubliners);

        Product[] expected = new Product[]{Dubliners};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {
        repository.save(iPhoneSE20);

        Product[] expected = new Product[]{iPhoneSE20};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(Dubliners);
        repository.save(iPhoneSE20);
        repository.removeById(1003);

        Product[] expected = new Product[]{Dubliners};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}