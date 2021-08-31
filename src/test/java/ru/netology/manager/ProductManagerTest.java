package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Book Ulysses = new Book(69, "Ulysses", 1400, "Joyce");
    private Book Dubliners = new Book(124, "Dubliners", 1000, "Joyce");
    private Book GoldenApples = new Book(85, "The Golden Apples", 1000, "Welty");
    private Smartphone iPhoneSE16 = new Smartphone(717, "iPhoneSE16", 21000, "Apple");
    private Smartphone iPhoneSE20 = new Smartphone(1003, "iPhoneSE20", 44900, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(Ulysses);
        manager.add(Dubliners);
        manager.add(GoldenApples);
        manager.add(iPhoneSE16);
        manager.add(iPhoneSE20);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] returned = new Product[]{Ulysses, Dubliners, GoldenApples, iPhoneSE16, iPhoneSE20};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{Ulysses, Dubliners};
        Product[] actual = manager.searchBy("Joyce");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByApple() {
        Product[] returned = new Product[]{Ulysses, Dubliners, GoldenApples, iPhoneSE16, iPhoneSE20};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{GoldenApples, iPhoneSE16, iPhoneSE20};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByName() {
        Product[] returned = new Product[]{Ulysses, Dubliners, GoldenApples, iPhoneSE16, iPhoneSE20};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{iPhoneSE16, iPhoneSE20};
        Product[] actual = manager.searchBy("iPhone");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByWrongName() {
        Product[] returned = new Product[]{Ulysses, Dubliners, GoldenApples, iPhoneSE16, iPhoneSE20};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Honor");

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}



