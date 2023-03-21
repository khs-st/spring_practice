package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long,Item> store = new HashMap<>();
    private static long sequence= 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        // 한번 감싸서 반환하게 되면 ArrayList에 값을 넣어도 더이상 실제 store에는 변함이 없다.
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        // 가능한 updateParam을 그대로 Item 객체에서 가져오는 거보다 updateDto를 만들어 사용하는게 좋다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // 테스트용
    public void clearStroe(){
        store.clear();
    }

}
