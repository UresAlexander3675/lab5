package controller;

import models.*;
import java.beans.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Управляет сохранением и загрузкой коллекции маршрутов в XML-файл.
 */
public class FileManager {
    private final String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    /**
     * Сохраняет коллекцию маршрутов в XML-файл.
     * @param routes коллекция маршрутов
     */
    public void save(LinkedHashMap<Long, Route> routes) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(routes);
            System.out.println("Данные успешно сохранены в " + filename);
        } catch (Exception e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    /**
     * Загружает коллекцию маршрутов из XML-файла.
     * @return коллеция маршрутов
     */
    public LinkedHashMap<Long, Route> load() {
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("Файл не найден, создаём новый.");
            return new LinkedHashMap<>();
        }

        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (LinkedHashMap<Long, Route>) decoder.readObject();
        } catch (Exception e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
            return new LinkedHashMap<>();
        }
    }
}
