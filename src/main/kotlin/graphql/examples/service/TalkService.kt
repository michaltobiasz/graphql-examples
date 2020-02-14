package graphql.examples.service

import graphql.examples.pojo.Attendee
import graphql.examples.pojo.Speaker
import graphql.examples.pojo.Talk
import graphql.examples.repository.AttendeeTalkRepository
import graphql.examples.repository.SpeakerTalkRepository
import graphql.examples.repository.TalkRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TalkService(
    private val talkRepository: TalkRepository,
    private val speakerTalkRepository: SpeakerTalkRepository,
    private val attendeeTalkRepository: AttendeeTalkRepository
) {

    fun findAll(): List<Talk> {
        return talkRepository.findAll()
    }

    fun findAllTalksBySpeaker(speaker: Speaker): List<Talk> {
        val st = speakerTalkRepository.findAllBySpeakerId(speaker.id)

        return st.stream()
            .map { talkRepository.findById(it.talkId) }
            .filter { it.isPresent }
            .map { it.get() }
            .collect(Collectors.toList<Talk>())
    }

    fun findAllTAlksByAttendee(attendee: Attendee): List<Talk> {
        val st = attendeeTalkRepository.findAllByAttendeeId(attendee.id)

        return st.stream()
            .map { talkRepository.findById(it.talkId) }
            .filter { it.isPresent }
            .map { it.get() }
            .collect(Collectors.toList<Talk>())

    }
}
