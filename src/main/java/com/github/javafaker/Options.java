package com.github.javafaker;

import java.util.List;
import java.util.ArrayList;

public class Options {
    private final Faker faker;

    protected Options(Faker faker) {
        this.faker = faker;
    }

    /**
     * Returns a random element from an varargs.
     *
     * @param options The varargs to take a random element from.
     * @param <E>   The type of the elements in the varargs.
     * @return A randomly selected element from the varargs.
     */
    public <E> E option(E... options) {
        return options[faker.random().nextInt(options.length)];
    }

    /**
     * Returns a random element from Enum.
     *
     * @param enumeration The Enum to take a random element from.
     * @return A randomly selected element from the enum.
     */
    public <E extends Enum<E>> E option(Class<E> enumeration) {
        E[] enumConstants = enumeration.getEnumConstants();
        return enumConstants[faker.random().nextInt(enumConstants.length)];
    }

    /**
     * Returns a random element from an array.
     *
     * @param array The array to take a random element from.
     * @param <E>   The type of the elements in the array.
     * @return A randomly selected element from the array.
     */
    public <E> E nextElement(E[] array) {
        return array[faker.random().nextInt(array.length)];
    }

    /**
     * Returns a random element from a list.
     *
     * @param list The list to take a random element from.
     * @param <E>  The type of the elements in the list.
     * @return A randomly selected element from the list.
     */
    public <E> E nextElement(List<E> list) {
        return list.get(faker.random().nextInt(list.size()));
    }

    /**
     * Returns a random subset of the list passed in
     * @param list The list to take the random subset from. 
     * @param <E> The type of the elements in the list. 
     * @return A random subset of the list passed in. 
     */
    public <E> List<E> randomSubset(List<E> list) {
        int inputListSize = list.size();
        int subsetSize = faker.random().nextInt(inputListSize);
        
        //Ensure we get a non-empty subset when possible
        if (inputListSize != 0) {
            while (subsetSize <= 0) {
                subsetSize = faker.random().nextInt(inputListSize);
            }
        }

        List<E> toReturn = new ArrayList<E>();
        List<E> inputListCopy = new ArrayList<E>(list);
        
        for (int i = 0; i < subsetSize; i++) {
            int currListSize = inputListCopy.size();
            E toAdd = inputListCopy.remove(faker.random().nextInt(currListSize));
            toReturn.add(toAdd);
        }
        return toReturn;
    }
}
