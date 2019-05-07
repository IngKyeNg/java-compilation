package io.springbootquickstart.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{Id}")
    public Topic getTopic(@PathVariable String Id) {
        return topicService.getTopic(Id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{Id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String Id) {
        topicService.updateTopic(Id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{Id}")
    public void deleteTopic(@PathVariable String Id) {
        topicService.deleteTopic(Id);
    }
}
