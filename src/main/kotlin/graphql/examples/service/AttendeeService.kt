package graphql.examples.service

import graphql.examples.pojo.Attendee
import graphql.examples.pojo.Talk
import graphql.examples.repository.AttendeeRepository
import graphql.examples.repository.AttendeeTalkRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AttendeeService(
    private val attendeeRepository: AttendeeRepository,
    private val attendeeTalkRepository: AttendeeTalkRepository
) {

    fun findAll(): List<Attendee> {
        return attendeeRepository.findAll()
    }

    fun findAllAttendiesForTalk(talk: Talk): List<Attendee> {
        val at = attendeeTalkRepository.findAllByTalkId(talk.id)

        return at.stream()
            .map { attendeeRepository.findById(it.attendeeId) }
            .filter { it.isPresent }
            .map { it.get() }
            .collect(Collectors.toList<Attendee>())
    }
}
