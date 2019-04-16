package rocks.zipcode.io.collections;


import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {

    /**
     * @param collection - object to be converted to list
     * @param <E>        - type of collection
     * @return list with identical contents
     */
    public static <E> List<E> toList(Collection collection) {

        return new ArrayList<E>(collection);
    }

    /**
     * @param nestedCollection - collection to be evaluated
     * @param collection       - collections to be sought within `nestedCollection`
     * @return true if `nestedCollection` contains a collection with contents identical to `collection`
     */
    public static Boolean contains(Collection<? extends Collection<?>> nestedCollection, Collection<?> collection) {


        return flatten(nestedCollection.toArray(new Collection[0])).containsAll(collection);

    }

    /**
     * @param collections - collections to be nested
     * @return a single collection containing each of the collections passed in as an argument
     */
    public static Collection<? extends Collection<?>> nest(Collection<?>... collections) {
        List<Collection<? extends Collection<?>>> nestedList = new ArrayList<>();
        for(Collection thisCollection: collections){
            nestedList.add(thisCollection);
        }
        return nestedList;
    }

    /**
     * @param collections - collections to be combined
     * @return a single collection containing the aggregate contents of each collection passed in as an argument
     */
    public static Collection<?> flatten(Collection<?>... collections) {
       List<Collection> flatList = new ArrayList<>();
////        return flatList.stream().flatMap(collection -> collection.stream().collect(Collectors.toList()));
        for(Collection thisCollection: collections){
            flatList.addAll(thisCollection);
        }
        return flatList;
    }
}
