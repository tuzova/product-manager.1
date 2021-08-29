package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {                                  // менеджер умеет добавлять продукты в репозиторий
        repository.save(product);
    }

    public Product[] searchBy(String text) {                            // менеджер умеет осуществлять поиск по продуктам + ТЕСТ
        Product[] result = new Product[0];                              // результаты поиска в новый массив
        for (Product product : repository.findAll()) {                  // перебираем все продукты из репозитория
            if (matches(product, text)) {                               // для каждого продукта вызываем метод matches
                Product[] tmp = new Product[result.length + 1];         // увеличение нового массива

                System.arraycopy(result, 0, tmp, 0, result.length);     // копируем всё из result в tmp
                for (int i = 0; i < result.length; i++)

                    tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {            // метод проверяет, соответствует ли продукт поисковому запросу
        if (product instanceof Book) {                                  // если в параметре product лежит объект класса Book
            Book book = (Book) product;                                 // положим его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) {                    // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (product.getName().contains(search)) {                   // проверим есть ли поисковое слово в названии
                return true;
            }
            return false;
        } else {
            if (product instanceof Smartphone) {                        // если в параметре product лежит объект класса Smartphone
                Smartphone smartphone = (Smartphone) product;           // положим его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
                if (smartphone.getManufacturer().contains(search)) {    // проверим есть ли поисковое слово в данных о производителе
                    return true;
                }
                if (product.getName().contains(search)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public Product[] getAll() {
        Product[] products = repository.findAll();
        Product[] result = new Product[products.length];
        for (int i = 0; i < result.length; i++) {
            int index = products.length - i - 1;
            result[i] = products[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}