package graphql.examples.service

import graphql.examples.pojo.Speaker
import graphql.examples.pojo.Talk
import graphql.examples.repository.SpeakerRepository
import graphql.examples.repository.SpeakerTalkRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SpeakerService(
    private val speakerRepository: SpeakerRepository,
    private val speakerTalkRepository: SpeakerTalkRepository
) {

    fun findAll(): List<Speaker> {
        return speakerRepository.findAll()
    }

    fun findAllSpeakersForTalk(talk: Talk): List<Speaker> {
        val st = speakerTalkRepository.findAllByTalkId(talk.id)

        return st.stream()
            .map { speakerRepository.findById(it.speakerId) }
            .filter { it.isPresent }
            .map { it.get() }
            .collect(Collectors.toList<Speaker>())
    }

    fun save(speaker: Speaker): Speaker {
        return speakerRepository.save(speaker)
    }
}
