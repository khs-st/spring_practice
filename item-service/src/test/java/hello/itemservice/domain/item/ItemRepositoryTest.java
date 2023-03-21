package hello.itemservice.domain.item;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStroe();
    }

    @Test
    void save(){
        //given
        Item item = new Item("ItemA",10000,10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll(){
        //given
        Item item1 = new Item("Item1",10000,10);
        Item item2 = new Item("Item2",5000,50);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(item1,item2);

    }

    @Test
    void updateItem(){
        //given
        Item item1 = new Item("Item1",10000,10);

        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        //when
        Item updateParam = new Item("Itemaaa",15005,55);

        itemRepository.update(itemId,updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);

        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}
