package by.learning.shape.model.repository;

import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidRepository {

    private List<Pyramid> pyramidList = new ArrayList<>();

    public boolean add(Pyramid pyramid) {
        return pyramidList.add(pyramid);
    }

    public boolean addAll(Collection<? extends Pyramid> c) {
        return pyramidList.addAll(c);
    }

    public Pyramid get(int index) {
        return pyramidList.get(index);
    }

    public Pyramid set(int index, Pyramid element) {
        return pyramidList.set(index, element);
    }

    public void add(int index, Pyramid element) {
        pyramidList.add(index, element);
    }

    public Pyramid remove(int index) {
        return pyramidList.remove(index);
    }

    public List<Pyramid> sort(Comparator<? super Pyramid> c) {
        List<Pyramid> result = new ArrayList<>(pyramidList);
        result.sort(c);
        return result;
    }

    public List<Pyramid> query(Specification specification) {
        List<Pyramid> list = pyramidList.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }
}
