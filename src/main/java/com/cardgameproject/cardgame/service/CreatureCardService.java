package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureCardService {

    private CreatureCardRepository creatureRepository;
    @Autowired
    public CreatureCardService(CreatureCardRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public List<CreatureCard> getAllCreatures(){
        return (List<CreatureCard>) creatureRepository.findAll();
    }
    public void addCreatureCard(CreatureCard card){
        creatureRepository.save(card);
    }
    public CreatureCard findCreatureCardByName(String name){
        return creatureRepository.findCreatureCardByName(name);
    }
    public List<CreatureCard> findCardsByNameAndManaCost (String name, int manaCost){
        return creatureRepository.findCreatureCardByNameAndManaCost(name, manaCost);
    }

    public List<CreatureCard> findCardsByDetail(String detail){
        switch(detail){
            case "name":
                return creatureRepository.findAllByName(detail);
            case "manaCost":
                return creatureRepository.findAllByManaCost(Integer.parseInt(detail));
            case "baseAttack":
                return creatureRepository.findAllBybaseAttack(Integer.parseInt(detail));
            case "baseHealth":
                return creatureRepository.findAllBybaseHealth(Integer.parseInt(detail));
            default:
                System.out.println("No card found !");
        }
        return null;
    }
}
