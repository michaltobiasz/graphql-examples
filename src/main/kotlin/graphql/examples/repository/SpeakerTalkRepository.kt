package graphql.examples.repository

import graphql.examples.pojo.SpeakerTalk
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpeakerTalkRepository : JpaRepository<SpeakerTalk, Long> {
    fun findAllBySpeakerId(speakerId: Long): List<SpeakerTalk>
    fun findAllByTalkId(talkId: Long): List<SpeakerTalk>
}
