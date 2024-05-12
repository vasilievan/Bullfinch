#include "AudioEngine.h"
#include <oboe/AudioStreamBuilder.h>
#include <oboe/AudioStream.h>

using namespace oboe;

void AudioEngine::start() {
    AudioStreamBuilder builder;

    builder.setCallback(this);
    builder.setDirection(Direction::Input);
    builder.setPerformanceMode(PerformanceMode::LowLatency);

    AudioStream *stream;
    Result r = builder.openStream(&stream);
    if (r != Result::OK) {

    }

    r = stream->requestStart();
    if (r != Result::OK) {

    }
}

void AudioEngine::closeStream(std::shared_ptr<oboe::AudioStream> &stream) {
    if (stream) {
        oboe::Result result = stream->stop();
        if (result != oboe::Result::OK) {
            // LOGW("Error stopping stream: %s", oboe::convertToText(result));
        }
        result = stream->close();
        if (result != oboe::Result::OK) {
            // LOGE("Error closing stream: %s", oboe::convertToText(result));
        } else {
            // LOGW("Successfully closed streams");
        }
        stream.reset();
    }
}

void AudioEngine::closeStreams() {
    closeStream(playStream);
}

DataCallbackResult
AudioEngine::onAudioReady(AudioStream *audioStream, void *audioData, int32_t numFrames) {
    return DataCallbackResult::Continue;
}