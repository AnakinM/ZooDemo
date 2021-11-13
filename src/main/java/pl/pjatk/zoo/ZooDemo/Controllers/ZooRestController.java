package pl.pjatk.zoo.ZooDemo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;
import pl.pjatk.zoo.ZooDemo.Services.ZooService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    private final ZooService zooService;

    public ZooRestController(ZooService zooService){
        this.zooService = zooService;
    }

    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        return ResponseEntity.ok(zooService.getExampleZoo());
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> getEmptyZoo() {
        return ResponseEntity.ok(zooService.getEmptyZoo());
    }

    @GetMapping("/emptywithname")
    public ResponseEntity<Zoo> getEmptyZooWithName() {
        return ResponseEntity.ok(zooService.getEmptyZooForName("exampleName"));
    }

    @GetMapping("/allZoos")
    public ResponseEntity<List<Zoo>> getAllZoos() {
        return ResponseEntity.ok(zooService.findAllZoos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Zoo>> getZooById(@PathVariable("id") Integer id) {
        Optional<Zoo> zoo = zooService.findZooById(id);
        return ResponseEntity.ok(zoo);
    }
}
