package graphql.examples.repository

import graphql.examples.pojo.AttendeeTalk
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeTalkRepository : JpaRepository<AttendeeTalk, Long> {
    fun findAllByAttendeeId(attendeeId: Long): List<AttendeeTalk>

    fun findAllByTalkId(talkId: Long): List<AttendeeTalk>
}
