package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    /**
     * 상품 목록
     * @param model
     * @return
     */
    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "/basic/items";
    }

    /**
     * 상품 상세
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "/basic/item";
    }

    /**
     * 상품 등록 폼
     */
    @GetMapping("/add")
    public String addForm(){
        return "/basic/addForm";
    }

    /**
     * 상품 등록 - V1(@RequestParam 이용)
     */
    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);
        model.addAttribute("item", item);
        return "basic/item";
    }

    /**
     * 상품 등록 - V2(@ModelAttribute 이용)
     * @ModelAttribute("hello") Item item 이름을 hello 로 지정
     * addItemV2 - 상품 등록 처리 - ModelAttribute
     */
    //@PostMapping("/add")
    public String addItemV2(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);
        //model.addAttribute("item", item); //자동 추가, 생략 가능
        return "basic/item";
    }

    /**
     * 상품 등록 - V3(@ModelAttribute 이용)
     * addItemV3 - 상품 등록 처리 - ModelAttribute 이름 생략
     */
    @PostMapping("/add")
    public String addItemV3(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * 상품 수정 폼
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "/basic/editForm";
    }

    /**
     * 상품 수정
     * @param itemId, item
     * @return
     */
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트용 데이터
     */
    @PostConstruct
    public void init(){
        itemRepository.save((new Item("itemA",10000,10)));
        itemRepository.save((new Item("itemB",15000,50)));
    }
}
